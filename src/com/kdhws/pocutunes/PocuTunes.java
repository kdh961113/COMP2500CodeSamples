package com.kdhws.pocutunes;

import java.util.ArrayList;
public class PocuTunes { // PocuTunes class 선언
    private ArrayList<Song> songs; // 멤버 배열 변수 ArrayList<song>을 선언하고 ArratList의 배열 songs를 선언함.
    private ArrayList<Playlist> playlists; // 멤버 배열 변수 ArrayList<PlayList>를 선언하고 배열 playlists를 선언함.
    //PocuTunes의 private 멤버 변수들, Song과 playlist 클래스를 모두 참조함
    //기존의 클래스들을 사용하여 새 클래스를 만드는 컴포지션의 예
    
    public PocuTunes() {
        this(new ArrayList<Song>(), new ArrayList<Playlist>());
    }
    // 개체 PocuTunes 선언, ArrayList<song>, ArrayList<PlayList> 각각의 값을 받는 생성자 새로 할당.
    //매개변수 없는 생성자. 내부에서 다른 오버로딩된 생성자를 호출하는 모습을 볼 수 있음
    public PocuTunes(ArrayList<Song> songs, ArrayList<Playlist> playlists) {
        // 개체 PocuTune에 멤버 배열 변수 ArrayList<Song>의 오버로딩된 생성자인 songs와
        // ArrayList<Playlist)의 오버로딩 된 생성자인 playlists 를 가져옴
        this.songs = songs; // 오버로딩된 songs의 값을 배열 songs에 대입함.
        this.playlists = playlists; //오버로딩된 playlist의 값을 배열 playlists에 대입함.
    } //다른 생성자. 노래와 재생목록들을 초기화

    public int getSongCount() {
        return this.songs.size();
    }
    // int 개체 getSongCount 선언, song 생성자의 size값을 return함.
    //PocuTunes에 있는 총 곡 수를 반환

    public void addSong(Song song) {
        this.songs.add(song);
    }
    // void 개체 addSong을 선언, ArrayList<Song>의 오버로딩된 생성자인 songs의 값을 song에 대입하고 추가함.
    // 노래 리스트에 노래를 추가, 내부 Array는 잘 모를 것.
    
    public boolean removeSong(String songName) { //boolen 개체 removeSong을 선언, 문자열 sonName을 선언
        for (Playlist playlist : this.playlists) { //for문, ArrayList<Playlist>의 배열 playlist와 생성자 playlists의 값을 비교
            playlist.removeSong(songName); 
            // 문자열 songname에 있는 값들을 Playlist Class의 boolean 개체 removeSong을 불러와서 playlist에 대입
        } // 모든 재생목록으로부터도 이 곡을 제거해야함

        Song songOrNull = findSongOrNull(songName); 
        // Playlist Class의 멤버 변수 배열 ArrayList<song>에 개체 findSongOrNull를 songName에 대입 시킨 값을
        //Song 개체를 생성하여 대입 시킨다.
        //findSongOrNull() 메서드(멤버 함수)를 호출, 왜냐하면 PocuTunes에도 findSongOrNull()이란 private 메서드(멤버함수)가 있기 때문

        if (songOrNull == null) { //if문, songOrNUll의 값이 null이라면
            return false;   //false를 반환한다.
        }

        this.songs.remove(songOrNull); // songOrull을 remove 개체에 대입하여 생성자 song에 대입하여 해당 생성자가의 변수를 삭제한다.
        return true; // true를 반환한다.
    } // 노래 리스트에서 노래를 제거. Playlist 클래스에서 봤던 removeSong() 메서드와 기본적으로 같은 로직

    public void addPlaylist(Playlist playlist) {
        this.playlists.add(playlist);
    }
    // void 개체 addPlaylist를 선언한다. ArrayList<Playlist>의 배열에 playlist를 추가 선언한다.
    //  ArrayList<Playlist>의 배열에 있는 playlist의 값을 add 개체를 사용해서 생성자 playlist의 값에 추가한다.
    //새 재생목록을 추가

    public boolean removePlaylist(String playlistName) {
        //boolean 개체 removePlaylist를 선언한다. 문자열 playlistName를 생성한다.
        for (Playlist playlist : this.playlists) { // for문
            //Playlist의 playlist라는 문자열을 생성하고 생성자 playlists와  비교를 한다.
            if (playlistName.equals(playlist.getName())) { // if문
        // playlist Class의 개체 getName을 불러와 playlist에 대입한 값을 문자열 비교문인 equals를 사용하여 playlistName과 비교한다.
                this.playlists.remove(playlist);
                //playlist 문자열 값과 같은 생성자 playlists 값을 remove 개체를 이용해서 삭제한다.
                return true;// ture를 return 한다.
            }
        }

        return false; // false를 return 한다.
    } //재생목록을 제거하는 것도 가능. 재생목록을 찾는 데 성공하면 지움

    public void playSong(String songName) {
        //void 개체 playSong 선언, 문자열 songName 선언
        Song songOrNull = findSongOrNull(songName);
        //Playlist Class의 멤버 변수 배열 ArrayList<song>에 개체 findSongOrNull를 songName에 대입 시킨 값을
        // Song 개체에 대입한다.
        //findSongOrNull() 메서드(개체)를 사용하여 원하는 곡을 찾는다.
        //이렇듯 private 메서드를 사용하면 한 곳에 정의한 공통 로직을 여러 곳에서 사용 할 수 있다.

        if (songOrNull == null) { // if문, SongOrNull이 null 이라면
            System.out.println(String.format("\"%s\" not found!", songName));
            return; //출력문, 문자열 songName을 출력한다.
        } // 찾지 못해서 곡이 존재하지 않으면(songOrNull == null), 그런 곡이 없다는 메시지를 출력

        songOrNull.play();
        //songOrNull의 값을 play 개체에 대입함.
        // 그게 아니라면 그 곡을 플레이
    } // 이 메서드를 사용하면 특정 곡을 플레이 할 수 있음

    public void playPlaylist(String playlistName) {
        //void 개체 playPlaylist를 선언, 문자열 playlistName을 선언함.
        Playlist playlist = findPlaylistOrNull(playlistName);
        // 문자열 Playlist의 변수 playlist를 선언하고 playlistName의 값을 개체  findPlaylistOrNull(playlistName)에 대입한다.
        // 곡이 아니라 재생목록을 찾는데 이건 그냥 findPlaylistOrNull()이라는 다른 private 메서드를 호출함

        if (playlist == null) {// if 문, playlist의 값이 null이라면
            System.out.println(String.format("Playlist %s not found!", playlistName));// 출력문, 문자열 playlistName을 출력
            return;
        } // playPlaylist() 메서드는 playSong() 메서드와 크게 다르지 않음

        playlist.play();
        //playlist의 값을 play 함수에 대입
    }

    private Playlist findPlaylistOrNull(String playlistName) {
        //멤버 배열 변수 ArrayList<PlayList>의 배열 playlists에 개체 findPlaylistOrNull를 선언하고, 개체 playlistName에 값을 대입
        for (Playlist playlist : this.playlists) { //for문, Playlist의 배열 변수 playlist를 선언하고 생성자 playList와 비교
            if (playlistName.equals(playlist.getName())) { //if문
            // playlist Class의 개체 getName을 불러와 playlist에 대입한 값을 문자열 비교문인 equals를 사용하여 playlistName이랑 비교
                return playlist; //playlist의 값을 반환함.
            }
        }

        return null; // null 반환
    } //findSongOrNull()과 똑같은 로직. 곡 대신에 재생목록을 찾는게 유일한 차이점

    private Song findSongOrNull(String songName) {
        //멤버 변수 배열 ArrayList<song>에 개체 findSongOrNull 생성하고 개체 songName에 값 대입

        for (Song song : this.songs) { //for문, Song의 배열 변수 song을 선언하고 생성자 songs와 비교
            if (songName.equals(song.getName())) {
           // playlist Class의 멤버 함수 getName을 불러와 song에 대입한 값을 문자열 비교문인 equals를 사용하여 songName이랑 비교
                return song; //song의 값을 반환
            }
        }

        return null; // null 값을 반환
    }
}
