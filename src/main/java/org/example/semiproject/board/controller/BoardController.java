package org.example.semiproject.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.example.semiproject.board.service.BoardJpaService;
import org.example.semiproject.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;
    private final BoardJpaService boardJpaService;

    @GetMapping("/list")
    public String list(Model m, @RequestParam(defaultValue = "1") int cpg) {
        // RequestParam에 defaultValue를 이용하면
        // cpg 매개변수가 전달되지 않을 경우 기본값인 1이 전달됨
        log.info("board/list 호출!!");

        m.addAttribute("bds", boardService.readBoard(cpg));

        m.addAttribute("cpg", cpg);
        m.addAttribute("stblk", ((cpg - 1) / 10) * 10 + 1);

        return "board/list";
    }

    @GetMapping("/list2")
    public String list2(Model m, @RequestParam(defaultValue = "1") int cpg) {
        // RequestParam에 defaultValue를 이용하면
        // cpg 매개변수가 전달되지 않을 경우 기본값인 1이 전달됨
        log.info("board/list2 호출!!");

        //m.addAttribute("bds", boardJpaService.getBoardList());
        m.addAttribute("bds", boardJpaService.getBoardList(cpg));

        m.addAttribute("cpg", cpg);
        m.addAttribute("stblk", ((cpg - 1) / 10) * 10 + 1);

        return "board/list";
    }    

    @GetMapping("/view")
    public String view(Model m, int bno) {

        m.addAttribute("bd", boardService.readOneBoard(bno));

        return "board/view";
    }

}

