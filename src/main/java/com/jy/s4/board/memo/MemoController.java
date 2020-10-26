package com.jy.s4.board.memo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jy.s4.util.Pager;

@Controller
@RequestMapping("/memo/**")
public class MemoController {
	@Autowired
	private MemoService memoService;
	
	@GetMapping("memoList")
	public void getList(Pager pager) throws Exception{
		List<MemoDTO> ar = memoService.getList(pager);
		
	}
	
	@PostMapping("memoWrite")
	public void setInsert(MemoDTO memoDTO) throws Exception{
		int result = memoService.setInsert(memoDTO);
	}
	
	@GetMapping("memoTest")
	public void memoTest()  throws Exception{
		System.out.println("memo test");
	}
	
	@GetMapping("memoPage")
	public void memoPage() throws Exception{
	
	}
	
}
