package com.kdhws.pocutunes;

//PocuTunes는 재생목록 기능도 지원, 재생목록에 즐겨 듣는 음악을 추가하고 이름도 지정할 수 있음
import java.util.ArrayList;
public class Playlist { //Playlist 클래스 선언
    private String name; // 문자열 멤버 변수 name 선언
    private ArrayList<Song> songs; // ArrayList<Song> 멤버 배열 songs 선언
    //Playlost 클래스의 private 멤버 변수들, Playlist는 곡의 리스트를 가질 것임
    public Playlist(String name) { // 멤버 함수 선언하고 문자열 name을 선언 하고 대입
        this.name = name; // 생성자 name 선언하고 name에 대입
        this.songs = new ArrayList<Song>(); // 생성자 songs 선언하고 Array<Song>에 새로운 배열 선언 및 대입
    }
    //생성자에서 초기화,

    public String getName() {
        return this.name;
    } // 개체 getName 선언하고 name 생성자의 값 return함.
    //name용 getter 메서드
    public void setName(String name) {
        this.name = name;
    } // 개체 setName 선언하고 문자열 name에 대입, 생성자 name에도 대입
    //name용 setter 메서드. 이 메서드를 통해 재생목록의 이름을 바꿀 수 있음

    public void addSong(Song song) {
        this.songs.add(song);
    } // 개체 addSong 선언하고 ArrayList<song>에 대입
    // 생성자 song에도 add로 추가 대입
    //재생목록에 노래를 추가할 수도 있다.

    public boolean removeSong(String songName) { //  boolean 개체 선언, 문자열 songName에 값 대입
        Song song = findSongOrNull(songName); //우선 재생목록에 그 노래가 있는지 확인, findSongOrNull() 메서드가 그런 일을 해줌
        // Song 개체 선언, PocuTunes class의 멤버 함수의 songName에 값을 대입

        if (song == null) { //if문 선언, 만약 노래가 null이면(즉, 재생목록에 그 노래가 없다면)
            return false; //false를 반환
        }

        this.songs.remove(song); // song의 값을 받아서 remove 개체에 대입하여 삭제, 삭제하는 해당 변수는 ArrayList<Song>의 배열
        return true;
        // false가 아니라면 재생목록으로 부터 노래를 제거한 뒤 true를 반환
    }// 노래 제거

    public void play() { // void 개체 play 선언
        System.out.println(String.format("---Playing %s---", this.name)); // 출력문, 생성자 name의 문자열 값 출력

        for (Song song : songs) { //if문, 멤버 배열의 ArrayList<Song> songs에 있는 배열들을 검색함.
            song.play(); //개체 play을 Song 개체에 문자열 song 대입
        } //for(반목문)에서 모든 곡들을 방문하면서 Song 클래스의 play() 메서드를 호출

        System.out.println(String.format("---Done playing %s---", this.name)); // 출력문, 생성자 name의 문자열 값 출력
    }

    private Song findSongOrNull(String songName) { 
        // 멤버 변수 배열 ArrayList<song>에 개체 findSongOrNull 생성하고 sonName에 값을 대입 한것이 Song 개체이다.
        for (Song song : this.songs) { //for문 선언, 맴버 변수 배열 ArryList<Song> 배열 값과 생성자 song의 값을 비교
            if (songName.equals(song.getName())) {
                // if문 선언, Song class에 있는 getName 개체와 Song 객체 배열 songNam를 멤버 함수 equals를
                //사용하서 서로 문자열 비교를 한다.
                return song; // song의 값을 return 한다.
            }
        } //이 메서드는 노래의 목록을 전부다 순회하면서 올바른 곡을 찾아 반환
        //findSongOrNull 매서드, private 메서드 이므로 Playlist 클래스 안에 있는 다른 메서드들만 이 메서드를 이용가능

        return null; // 못 찾은 경우에는 null을 반환
    }
}
