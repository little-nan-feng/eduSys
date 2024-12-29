package com.nanfeng.controller;


import com.nanfeng.service.SelectionService;
import com.nanfeng.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/selection")
@CrossOrigin
public class selectionController {

    @Autowired
    private SelectionService selectionService;

    @GetMapping("getSelection")
    public Result getSelection(@RequestParam("id") String id) {
        Result result = selectionService.getSelection(id);
        return result;
    }

    @GetMapping("setSelection")
    public Result setSelection(@RequestParam("sid") String sid, @RequestParam("cid") Integer cid) {
        Result result = selectionService.setSelection(sid,cid);
        return result;
    }

    @DeleteMapping("deleteSelection")
    public Result deleteSelection(@RequestParam("sid") String sid, @RequestParam("cid") Integer cid) {
        Result result = selectionService.deleteSelection(sid,cid);
        return result;
    }
}
