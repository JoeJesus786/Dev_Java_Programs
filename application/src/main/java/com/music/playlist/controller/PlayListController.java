package com.music.playlist.controller;

import com.music.playlist.dto.PlayListRequest;
import com.music.playlist.model.PlayList;
import com.music.playlist.service.PlayListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/playlists")
public class PlayListController {

    private final PlayListService playListService;

    public PlayListController(PlayListService playListService) {
        this.playListService = playListService;
    }

    @PostMapping()
    public ResponseEntity<PlayList> createPlayList(@RequestBody PlayListRequest playListRequest){

    	PlayList created = playListService.createPlayList(playListRequest);
        return new ResponseEntity<>(created, HttpStatus.CREATED);

    }

    @GetMapping("/{playListId}")
    public ResponseEntity<PlayList> getPlayListById(@PathVariable Long playListId){

    	PlayList playList = playListService.getPlayListByID(playListId);
        return new ResponseEntity<>(playList, HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<PlayList>> getAllPlayLists(){

    	List<PlayList> playLists = playListService.getPlayLists();
        return new ResponseEntity<>(playLists, HttpStatus.OK);

    }

    @DeleteMapping("/{playListId}")
    public ResponseEntity<Void> deletePlayList(@PathVariable Long playListId){

    	playListService.deletePlayList(playListId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
