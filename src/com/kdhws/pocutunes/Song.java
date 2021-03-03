package com.kdhws.pocutunes;

public class Song {
    private String artist; // 문자열 멤버 변수 artist 선언
    private String name; // 문자열 멤버 변수 name 선언
    private int playTimeInMilliSeconds; // 멤버 int 변수 playTimeInMilliSeconds 선언

    // private 멤버 변수들 이 클래스 외부에서 접근 불가
    // 달리 말하자면 song 클래스 밖에 있는 메서드 안에서 이 변수들에 접근 할 수 없음
    //하지만 song 클래스의 메서드 안에서는 접근 가능

    public Song(String artist, String name, int playTimeInMilliSeconds) { 
        // 개체 song을  선언하고 문자열 멤버 변수 artist, name, 문자열 int 변수 playTimeInMilliSeconds에 값을 대입
        this.artist = artist; // 멤버 변수 artist의 값을 대입 받는 생성자 artist 선언
        this.name = name;   // 멤버 변수 name의 값을 대입 받는 생성자 name 선언
        this.playTimeInMilliSeconds = playTimeInMilliSeconds; 
        // 멤버 int 변수 playTimeInMilliSeconds의 값을 대입 받는 생성자 playTimeInMilliSeconds 선언
    }
    // 멤버변수를 초기화 하는 생성자

    public String getArtist() {
        return this.artist;
    }
    // 문자열 객체 getArtist를 선언하고 artist의 값을 return함
    // Song 클래스 외부에서 private 멤버 변수인 artist에 접근 할 수 있도록 getter 메서드를 만듬
    //getArtist()는 Song 클래스 내부의 메서드(멤버 함수)이므로 생성자 artist에 직접 접근 가능
    public String getName() {
        return this.name;
    }
    // 문자열 객체 getName을 선언하고 name의 값을 return함.
    //getName()은 클래스 내부의 메서드(멤버 함수) 이므로 name에 생성자 직접 접근 가능
    public int getPlaytimeInMilliSeconds() {
        return this.playTimeInMilliSeconds;
    }
    // int 객체 playTimeInMilliSeconds()를 선언하고 playTimeInMilliSeconds의 값을 return함
    //playTimeInMilliSeconds()은 클래스 내부의 int형 변수 이므로 생성자 playTimeInMilliSeconds에 직접 접근 가능
    public void play() { //멤버 함수 play를 선언
        System.out.printf("Playing %s by %s. Duration is %d milliseconds%s",
                this.name,
                this.artist,
                this.playTimeInMilliSeconds,
                System.lineSeparator());
        // 문자열 출력, 생성자 name, artist, playTimeInMilliSeconds을 출력
        //play() 메서드(개체)에서 실제 음악을 플레이하는 대신 현재 Song 개체의 정보를 화면에 출력함
    }
}
