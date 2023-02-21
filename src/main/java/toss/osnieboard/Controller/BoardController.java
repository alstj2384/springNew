package toss.osnieboard.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import toss.osnieboard.domain.Board;
import toss.osnieboard.service.BoardService;

@Controller // 어노테이션을 입력하면 알아서 상단에 import 가 된다!
@RequestMapping("/board/**")
@RequiredArgsConstructor // lombok을 이용한 생성자 주입을 줄여주는 어노테이션
public class BoardController {
    private final BoardService service;

    @GetMapping("/hello")
    public String Hello() {
        return "/boards/hello";
    }

    @GetMapping("/test")
    public String Test(Model model){
        model.addAttribute("cnt", service.boardCount());
        model.addAttribute("test", service.boardList());

        return "/boards/hello";

    }

    @GetMapping("/main")
    public String main(Model model){
        model.addAttribute("list", service.boardList());

        return "/boards/main";
    }


    @GetMapping("/upload")
    public String uploadBoardForm(){
        return "/boards/upload";
    }
    @PostMapping("/upload")
    public String uploadBoard(Board board){
        service.uploadBoard(board);
        return "redirect:/board/main";
    }

    @GetMapping("/update") // 업데이트를 눌렀을 때
    public String updateBoardForm(Model model, Long boardId) {
        model.addAttribute("update", service.getBoard(boardId));

        return "/boards/update";
    }

    @PostMapping("/update")
    public String updateBoard(Board board) {
        service.updateBoard(board);
        return "redirect:/board/main";
    }

    @GetMapping("/delete")
    public String deleteBoard(Long boardId) {
        service.deleteBoard(boardId);
        return "redirect:/board/main";
    }

}
