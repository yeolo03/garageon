package cf.garageon.app.Controller;

import java.io.File;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cf.garageon.app.DAO.BoardDAO;
import cf.garageon.app.Service.*;
import cf.garageon.app.util.UploadFileUtils;
import cf.garageon.app.VO.*;


@Controller
public class BoardController {
private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject	
	BoardService service;
	@Inject
	ReplyService replyService;
	@Inject
	QnaService qnaService;
	@Inject
    QnaReplyService qnaReplyService;
	@Inject
	NoticeService noticeService;
	@Inject
	ItemService itemService;
	@Inject
	ItemReplyService itemReplyService;
	
	
	// 보통 @Value 를 사용하여 properties 로 경로를 받습니다. (기존소스 잔재 오류로 주석)
//	@Resource(name="uploadPath")
	public String uploadPath;
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	//초기화면 	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public void index() throws Exception{
		logger.info("index");
		
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public @ResponseBody String test() {
		return "Hello World";
	}
	

	
	
	// 게시판 글 작성 화면
		@RequestMapping(value = "/board/writeView", method = RequestMethod.GET)
		public void writeView() throws Exception{
			logger.info("board/writeView");
			
		}
		
		/// 게시판 글 작성
		@RequestMapping(value = "/board/write", method = RequestMethod.POST)
		public String write(BoardVO vo,MultipartHttpServletRequest mul,MultipartFile file) throws Exception{
			logger.info("write");
			
			String imgUploadPath = uploadPath + File.separator + "imgUpload";
			String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
			String fileName = null;

			if(file != null) {
			 fileName =  UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath); 
			} else {
			 fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
			}

			vo.setReview_Image(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
			//vo.setGdsThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
			service.write(vo,mul);
			return "redirect:/board/list";
		}
		
		// 게시판 목록 조회
		@RequestMapping(value = "board/list", method = RequestMethod.GET)
		public String list(Model model, @ModelAttribute("scri") SearchCriteria scri) throws Exception{
			logger.info("list");
			
			model.addAttribute("list",service.list(scri));
			
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(scri);
			pageMaker.setTotalCount(service.listCount(scri));
			
			model.addAttribute("pageMaker", pageMaker);
			
			return "board/list";
			
		}
		
		// 게시판 조회
		@RequestMapping(value = "/board/readView", method = RequestMethod.GET)
		public String read(BoardVO boardVO, Model model,@ModelAttribute("scri") SearchCriteria scri) throws Exception{
			logger.info("read");
			
			model.addAttribute("read", service.read(boardVO.getBno()));
			model.addAttribute("scri",scri);
			
			List<ReplyVO> replyList =replyService.readReply(boardVO.getBno());
			model.addAttribute("replyList",replyList);
			
			List<Map<String, Object>> fileList = service.selectFileList(boardVO.getBno());
			model.addAttribute("file", fileList);
			
			return "board/readView";
		}
		/*@RequestMapping(value="/fileDown")
		public void fileDown(@RequestParam Map<String, Object> map, HttpServletResponse response) throws Exception{
			Map<String, Object> resultMap = service.selectFileInfo(map);
			String storedFileName = (String) resultMap.get("STORED_FILE_NAME");
			String originalFileName = (String) resultMap.get("ORG_FILE_NAME");
			
			// 파일을 저장했던 위치에서 첨부파일을 읽어 byte[]형식으로 변환한다.
			byte fileByte[] = org.apache.commons.io.FileUtils.readFileToByteArray(new File("C:\\mp\\file\\"+storedFileName));
			
			response.setContentType("application/octet-stream");
			response.setContentLength(fileByte.length);
			response.setHeader("Content-Disposition",  "attachment; fileName=\""+URLEncoder.encode(originalFileName, "UTF-8")+"\";");
			response.getOutputStream().write(fileByte);
			response.getOutputStream().flush();
			response.getOutputStream().close();
			
		}*/
		// 후기 게시판 수정뷰
		@RequestMapping(value = "/board/modifyView", method = RequestMethod.GET)
		public String review_modify(BoardVO boardVO, @ModelAttribute("scri") SearchCriteria scri, Model model) throws Exception{
			logger.info("updateView"); 	
			
			//model.addAttribute("modify", service.read(boardVO.getBno()));
			
			model.addAttribute("modify", service.read(boardVO.getBno()));
			model.addAttribute("scri", scri);

			List<Map<String, Object>> fileList = service.selectFileList(boardVO.getBno());
			model.addAttribute("file", fileList);
			
			return "board/modifyView";
		}
		//후기 게시판 수정
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
       public String modify(BoardVO boardVO, 
				 @ModelAttribute("scri") SearchCriteria scri, 
				 RedirectAttributes rttr,
				 @RequestParam(value="fileNoDel[]") String[] files,
				 @RequestParam(value="fileNameDel[]") String[] fileNames,
				 MultipartHttpServletRequest mpRequest) throws Exception{
		
		service.modify(boardVO, files, fileNames, mpRequest);

		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());
		
		return "redirect:/list";
		
		
	}
	
	//후기게시판 글 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String review_delete(BoardVO boardVO) throws Exception{
		service.delete(boardVO.getBno());
		
		return "redirect:/list";
		
	
	}
		
	//댓글 수정 GET
		@RequestMapping(value="/replyUpdateView", method = RequestMethod.GET)
		public String replyUpdateView(@RequestParam("rno") int rno ,ReplyVO vo,  Model model, SearchCriteria scri) throws Exception {
			logger.info("reply Write");
			
			model.addAttribute("replyUpdate", replyService.selectReply(vo.getRno()));
			model.addAttribute("scri", scri);
			
			
			return "board/replyUpdateView";
		}
		
		//댓글 수정 POST
		@RequestMapping(value="/replyUpdate", method = RequestMethod.POST)
		public String replyUpdate(ReplyVO vo,  SearchCriteria scri, RedirectAttributes rttr) throws Exception {
			logger.info("reply Write");
			
			replyService.updateReply(vo);
			
			rttr.addAttribute("bno", vo.getBno());
			rttr.addAttribute("page", scri.getPage());
			rttr.addAttribute("perPageNum", scri.getPerPageNum());
			rttr.addAttribute("searchType", scri.getSearchType());
			rttr.addAttribute("keyword", scri.getKeyword());
			
			
			return "redirect:/board/readView";
		}
		
		//댓글 삭제 GET
		@RequestMapping(value="/replyDeleteView", method = RequestMethod.GET)
		public String replyDeleteView(ReplyVO vo, SearchCriteria scri, Model model) throws Exception {
			logger.info("reply Write");
			
			model.addAttribute("replyDelete", replyService.selectReply(vo.getRno()));
			model.addAttribute("scri", scri);
			

			return "board/replyDeleteView";
		}
		
		//댓글 삭제 POST
		@RequestMapping(value="/replyDelete", method = RequestMethod.POST)
		public String replyDelete(ReplyVO vo, SearchCriteria scri, RedirectAttributes rttr) throws Exception {
			logger.info("reply Write");
			
			replyService.deleteReply(vo);
			
			rttr.addAttribute("bno", vo.getBno());
			rttr.addAttribute("page", scri.getPage());
			rttr.addAttribute("perPageNum", scri.getPerPageNum());
			rttr.addAttribute("searchType", scri.getSearchType());
			rttr.addAttribute("keyword", scri.getKeyword());
			
			return "redirect:/board/readView";
		}
		
		//댓글 작성
		@RequestMapping(value="/replyWrite", method = RequestMethod.POST)
		public String replyWrite(ReplyVO vo, SearchCriteria scri, RedirectAttributes rttr) throws Exception {
			logger.info("reply Write");
			
			replyService.writeReply(vo);
			
			rttr.addAttribute("bno", vo.getBno());
			rttr.addAttribute("page", scri.getPage());
			rttr.addAttribute("perPageNum", scri.getPerPageNum());
			rttr.addAttribute("searchType", scri.getSearchType());
			rttr.addAttribute("keyword", scri.getKeyword());
			
			return "redirect:/board/readView";
		}
		
	
		
		
		
		// qna 목록 조회
				@RequestMapping(value = "/qna_list", method = RequestMethod.GET)
				public String qnAlist(Model model,QnaReplyVO vo) throws Exception{
					logger.info("list");
				
					model.addAttribute("list",qnaService.readQna());
					
				
				return "qna/qna_list";
					
		}
				
				
				//qna 작성
				@RequestMapping(value="/qna/write", method = RequestMethod.POST)
				public String qnaWrite(QnABoardVO vo) throws Exception {
					logger.info("reply Write");
					
					
					qnaService.writeQna(vo);
					
					
					return "redirect:qna/qna_list";
				}
				
				//QNA 글 작성 후 마이페이지에 보여주는 곳
				@RequestMapping(value="/qna/qna_test", method = RequestMethod.GET)
				public String qna_test(Model model,QnABoardVO vo) throws Exception {
					logger.info("reply Write");
					
					
					model.addAttribute("read1",qnaService.read_qna(vo.getQna_Number()) );
					
					List<QnaReplyVO> list=qnaReplyService.readQnaReply(vo.getQna_Number());
					model.addAttribute("list",list);
					
					
					return "qna/qna_test";
				}
				// qna 게시판 수정뷰
				@RequestMapping(value = "/qna/modifyView", method = RequestMethod.GET)
				public String qna_modify1(QnABoardVO vo, Model model) throws Exception{
					logger.info("updateView"); 	
					
					model.addAttribute("modify",qnaService.read_qna(vo.getQna_Number()) );
				
					return "qna/modifyView";
				}
				//qna 게시판 수정
			@RequestMapping(value = "/qna_modify", method = RequestMethod.POST)
		       public String notice_modify(QnABoardVO vo) throws Exception{
				//service.modify(boardVO);
				qnaService.modify(vo);
				return "redirect:/qna/qna_test";
				
				
			}
			
			//qna게시판 글 삭제
			@RequestMapping(value = "/qna_delete", method = RequestMethod.POST)
		    public String qna_delete(QnABoardVO vo) throws Exception{
				//service.delete(boardVO.getBno());
				qnaService.delete_qna(vo.getQna_Number());
				//noticeService.notice_delete(vo.getNotice_Number());
				return "redirect:/qna/qna_list";
				
			
			}
				
				
				//댓글 작성
				@RequestMapping(value="/qnaReplyWrite", method = RequestMethod.POST)
				public String writeQnaReply(QnaReplyVO vo,RedirectAttributes rttr) throws Exception {
					logger.info("reply Write");
					
					
					qnaReplyService.writeQnaReply(vo);
					rttr.addAttribute("qna_Number", vo.getQna_Number());
					
					
					return "redirect:/qna/qna_test";
				}
				
				//댓글 삭제 GET
				@RequestMapping(value="/qna/qnaReplyDeleteView", method = RequestMethod.GET)
				public String deleteQnaReplyView(QnaReplyVO vo,Model model) throws Exception {
					logger.info("qnaReplyDeleteView");
					
					
					model.addAttribute("qnaReplyDelete", qnaReplyService.selectQnaReply(vo.getQna_rNumber()));
					
					

					return "qna/qnaReplyDeleteView";
				}
				
				//댓글 삭제 POST
				@RequestMapping(value="/qna/qnaReplyDelete", method = RequestMethod.POST)
				public String deleteQnaReply(QnaReplyVO vo, RedirectAttributes rttr) throws Exception {
					logger.info("qnaReplyDelete");
					
					qnaReplyService.deleteQnaReply(vo);
					
					rttr.addAttribute("qna_Number", vo.getQna_Number());
					
					return "redirect:/qna/qna_test";
				}
				//댓글 수정 GET
				@RequestMapping(value="/qna/qnaReplyUpdateView", method = RequestMethod.GET)
				public String updateQnaReplyView(@RequestParam("qna_rNumber") int qna_rNumber,QnaReplyVO vo, Model model) throws Exception {
					logger.info("reply Write");
					
					model.addAttribute("qnaReplyUpdate", qnaReplyService.selectQnaReply(vo.getQna_rNumber()));
					
					
					
					return "qna/qnaReplyUpdateView";
				}
				
				//댓글 수정 POST
				@RequestMapping(value="/qna/qnaReplyUpdate", method = RequestMethod.POST)
				public String updupdateQnaReply(QnaReplyVO vo,RedirectAttributes rttr) throws Exception {
					logger.info("reply Write");
					
					qnaReplyService.updateQnaReply(vo);
					
					rttr.addAttribute("qna_Number", vo.getQna_Number());
					
					
					return "redirect:/qna/qna_test";
				}
				
				// 공지사항 게시판 목록 조회
				@RequestMapping(value = "/notice_list", method = RequestMethod.GET)
				public String notice_list(Model model, @ModelAttribute("scri") SearchCriteria scri) throws Exception{
					logger.info("list");
					
					model.addAttribute("list1",noticeService.notice_list(scri));
					
					
					PageMaker pageMaker = new PageMaker();
					pageMaker.setCri(scri);
					pageMaker.setTotalCount(noticeService.listCount());
					
					model.addAttribute("pageMaker", pageMaker);

					// jsp 폴더 구조로 반영이 되지 않아 에러남 다른쪽도 모두 확인해서 고쳐주셔야 할듯 합니다.
					return "notice/notice_list";
					
				}
				
				// 공지사항 게시판 글 작성 화면
				@RequestMapping(value = "/notice/writeView", method = RequestMethod.GET)
				public void notice_writeView() throws Exception{
					logger.info("notice/writeView");
					
				}
				
				// 공지사항 게시판 글 작성
				@RequestMapping(value = "/notice/write", method = RequestMethod.POST)
				public String notice_write(NoticeBoardVO vo,MultipartFile file/*MultipartHttpServletRequest mul*/) throws Exception{
					logger.info("write");
					/*
					String imgUploadPath = uploadPath + File.separator + "imgUpload";
					String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
					String fileName = null;

					if(file != null) {
					 fileName =  UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath); 
					} else {
					 fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
					}

					vo.setNotice_Image(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
					//vo.setGdsThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
					*/
					noticeService.notice_write(vo);
					//service.write(boardVO,mul);
					
					return "redirect:notice/notice_list";
				}
				
				// 공지사항 게시판 조회
				@RequestMapping(value = "/notice/readView", method = RequestMethod.GET)
				public String notice_read(NoticeBoardVO vo, Model model,@ModelAttribute("scri") SearchCriteria scri) throws Exception{
					logger.info("read");
					
					model.addAttribute("read", noticeService.notice_read(vo.getNotice_Number()));
					
					
					return "notice/readView";
				}
				
				// 공지사항 게시판 수정뷰
				@RequestMapping(value = "/notice/modifyView", method = RequestMethod.GET)
				public String notice_modify(NoticeBoardVO vo, Model model) throws Exception{
					logger.info("updateView"); 	
					
					model.addAttribute("modify1", noticeService.notice_read(vo.getNotice_Number()));
				
					return "notice/modifyView";
				}
				//공지사항 게시판 수정
			@RequestMapping(value = "/notice_modify", method = RequestMethod.POST)
		       public String notice_modify(NoticeBoardVO vo,MultipartFile file,HttpServletRequest req) throws Exception{
				//service.modify(boardVO);
				
				 if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
					  // 기존 파일을 삭제
					  new File(uploadPath + req.getParameter("notice_Image")).delete();
				
					  
					  // 새로 첨부한 파일을 등록
					  String imgUploadPath = uploadPath + File.separator + "imgUpload";
					  String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
					  String fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
					  
					  vo.setNotice_Image(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
				
					  
					 } else {  // 새로운 파일이 등록되지 않았다면
					  // 기존 이미지를 그대로 사용
						vo.setNotice_Image(req.getParameter("notice_Image"));
					  
					 }
				noticeService.notice_modify(vo);
				return "redirect:notice/notice_list";
				
				
			}
		
			
			//공지사항 글 삭제
			@RequestMapping(value = "/notice_delete", method = RequestMethod.POST)
		    public String notice_delete(NoticeBoardVO vo) throws Exception{
				//service.delete(boardVO.getBno());
				noticeService.notice_delete(vo.getNotice_Number());
				return "redirect:notice/notice_list";
				
			
			}
			
			// 상품등록  글 작성 화면
			@RequestMapping(value = "/items/item_register", method = RequestMethod.GET)
			public String item_register() throws Exception{
				logger.info("item_register");
				
				return "/items/item_register";
			}
			
			//상품등록
			@RequestMapping(value="/items/write", method = RequestMethod.POST)
			public String item_register(ItemVO vo,MultipartFile file) throws Exception {
				logger.info("reply Write");
				String imgUploadPath = uploadPath + File.separator + "imgUpload";
				String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
				String fileName = null;

				if(file != null) {
				 fileName =  UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath); 
				} else {
				 fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
				}

				vo.setItem_Image(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
				vo.setItem_Thumbimage(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
				
				itemService.item_write(vo);
				
				
				return "redirect:items/item_list";
			}
			
			// 상품등록  글 목록리스트
						@RequestMapping(value = "item_list", method = RequestMethod.GET)
						public String item_list(Model model,@ModelAttribute("scri") SearchCriteria scri) throws Exception{
							logger.info("item_register");
							model.addAttribute("list",itemService.item_list(scri));
							
							PageMaker pageMaker = new PageMaker();
							pageMaker.setCri(scri);
							pageMaker.setTotalCount(itemService.listCount());
							
							model.addAttribute("pageMaker", pageMaker);
							
							return "/items/item_list";
						}
						
						//상품등록 상세페이지
						@RequestMapping(value="/items/item_readView", method = RequestMethod.GET)
						public String item_read(Model model,ItemVO vo) throws Exception {
							logger.info("reply Write");
							
							model.addAttribute("read",itemService.item_read(vo.getItem_Number()));
				
							List<ItemReplyVO> list=itemReplyService.item_list(vo.getItem_Number());
									
							model.addAttribute("list",list);
							
							return "/items/item_readView";
						}
						
						// 상품등록 게시판 수정뷰
						@RequestMapping(value = "/items/item_modifyView", method = RequestMethod.GET)
						public String items_modify(ItemVO vo, Model model) throws Exception{
							logger.info("updateView"); 	
							
							
							model.addAttribute("modify", itemService.item_read(vo.getItem_Number()));
						
							return "/items/item_modifyView";
						}
						//상품등록 게시판 수정
					@RequestMapping(value = "/items/item_modify", method = RequestMethod.POST)
				       public String item_modify(ItemVO vo,MultipartFile file,HttpServletRequest req) throws Exception{
						// 새로운 파일이 등록되었는지 확인
						 if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
						  // 기존 파일을 삭제
						  new File(uploadPath + req.getParameter("item_Image")).delete();
						  new File(uploadPath + req.getParameter("item_Thumbimage")).delete();
						  
						  // 새로 첨부한 파일을 등록
						  String imgUploadPath = uploadPath + File.separator + "imgUpload";
						  String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
						  String fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
						  
						  vo.setItem_Image(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
						  vo.setItem_Thumbimage(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
						  
						 } else {  // 새로운 파일이 등록되지 않았다면
						  // 기존 이미지를 그대로 사용
						  vo.setItem_Image(req.getParameter("item_Image"));
						  vo.setItem_Thumbimage(req.getParameter("item_Thumbimage"));
						  
						 }
						
						
						itemService.item_modify(vo);
						return "redirect:items/item_list";
						
						
					}
					
					//상품등록  글 삭제
					@RequestMapping(value = "/items/item_delete", method = RequestMethod.POST)
				    public String item_delete(ItemVO vo) throws Exception{
						//service.delete(boardVO.getBno());
						itemService.item_delete(vo.getItem_Number());
						
						return "redirect:items/item_list";
						
					
					}
					
					//상품등록 댓글 작성
					@RequestMapping(value="/item_reply_witer", method = RequestMethod.POST)
					public String item_reply_witer(ItemReplyVO vo,RedirectAttributes rttr) throws Exception {
						logger.info("reply Write");

						itemReplyService.item_reply_write(vo);
						
						rttr.addAttribute("item_Number", vo.getItem_Number());
						
						
						return "redirect:/items/item_readView";
					}
					//댓글 수정 GET
					@RequestMapping(value="/items/item_replyUpdateView", method = RequestMethod.GET)
					public String item_replyUpdateView(@RequestParam("item_rNumber") int item_rNumber ,ItemReplyVO vo,  Model model, SearchCriteria scri) throws Exception {
						logger.info("reply Write");
						
						model.addAttribute("replyUpdate",itemReplyService.item_reply_select(vo.getItem_rNumber()));
						//model.addAttribute("replyUpdate", replyService.selectReply(vo.getRno()));
						model.addAttribute("scri", scri);
						
						
						return "items/item_replyUpdateView";
					}
					
					//댓글 수정 POST
					@RequestMapping(value="/items/item_replyUpdate", method = RequestMethod.POST)
					public String item_replyUpdate(ItemReplyVO vo, RedirectAttributes rttr) throws Exception {
						logger.info("reply Write");
						
						itemReplyService.item_reply_modify(vo);
						
						rttr.addAttribute("item_Number", vo.getItem_Number());
						
						
						
						return "redirect:/items/item_readView";
					}
					
					
					
					//댓글 삭제 GET
					@RequestMapping(value="/items/item_replyDeleteView", method = RequestMethod.GET)
					public String item_replyDeleteView(ItemReplyVO vo, SearchCriteria scri, Model model) throws Exception {
						logger.info("reply Write");
						
						//model.addAttribute("replyDelete", replyService.selectReply(vo.getRno()));
						model.addAttribute("replyDelete",itemReplyService.item_reply_select(vo.getItem_rNumber()));
						model.addAttribute("scri", scri);
						

						return "items/item_replyDeleteView";
					}
					
					//댓글 삭제 POST
					@RequestMapping(value="/items/item_replyDelete", method = RequestMethod.POST)
					public String item_replyDelete(ItemReplyVO vo, SearchCriteria scri, RedirectAttributes rttr) throws Exception {
						logger.info("reply Write");
						
						itemReplyService.item_reply_delete(vo);
						
						rttr.addAttribute("item_Number", vo.getItem_Number());
						
						
						return "redirect:/items/item_readView";
					}
						
			
}			