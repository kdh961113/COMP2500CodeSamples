package com.kdhws.pocutunes;

public class Program { //Program Class 설정
    public static void main(String[] args) { // 정적 멤버 함수 설정, 문자열 출력
        Song hotelCalifornia = new Song("Eagles",
                "Hotel California",
                180100);
// Song class에 접근하여 새로운 배열을 추가한다. Song의 개체 artist,name, playTimeInMilliSeconds에 값을 대입함.

        Song heaven = new Song("Led Zeppelin",
                "Stairway to Heaven",
                172100);
// Song class에 접근하여 새로운 배열을 추가한다. Song의 개체 artist,name, playTimeInMilliSeconds에 값을 대입함.

        Song havana = new Song("Camila Cabello",
                "Havana",
                182200);
// Song class에 접근하여 새로운 배열을 추가한다. Song의 개체 artist,name, playTimeInMilliSeconds에 값을 대입함.

        Song santaBaby = new Song("Ariana Grade",
                "Santa Baby",
                166220);
// Song class에 접근하여 새로운 배열을 추가한다. Song의 개체 artist,name, playTimeInMilliSeconds에 값을 대입함.

        Song houndDog = new Song("Elvis Presley",
                "Hound Dog",
                175220);
// Song class에 접근하여 새로운 배열을 추가한다. Song의 개체 artist,name, playTimeInMilliSeconds에 값을 대입함.

        Song basketCase = new Song("Green Day",
                "Basket Case",
                193000);
// Song class에 접근하여 새로운 배열을 추가한다. Song의 개체 artist,name, playTimeInMilliSeconds에 값을 대입함.

        Song christmas = new Song("Mariah Carey",
                "All I Want For Christmas Is You",
                18301);
        // Song class에 접근하여 새로운 배열을 추가한다. Song의 개체 artist,name, playTimeInMilliSeconds에 값을 대입함.

        System.out.printf("%s by %s. Playtime is %d.%s",
                hotelCalifornia.getName(),
                hotelCalifornia.getArtist(),
                hotelCalifornia.getPlaytimeInMilliSeconds(),
                System.lineSeparator());
        // 출력문 Song Class 개체들인 getName, getAritist, getPlaytimeInMilliSecondes()을 불러다가 출력한다.
        // Song 개체의 getter 메서드(멤버 함수)를 호출하는 모습. 이렇게 해서 private 멤버 변수의 값을 알 수 있다.

        Playlist playlist1 = new Playlist("Classic Rock"); 
        // Playlist라는 개체를 만들어으로 새로운 문자열을 생성하여 대입한다.
        // 'Classic Rock'이란 이름의 재생목록을 만든다.
        playlist1.addSong(hotelCalifornia);
        //playlist1에 addSong 객체를 사용하여 대입
        playlist1.addSong(heaven);
        //playlist1에 addSong 객체를 사용하여 대입
        playlist1.addSong(houndDog);
        //playlist1에 addSong 객체를 사용하여 대입
        // 곡 3개를 여기에 추가

        Playlist playlist2 = new Playlist("Millenial");
        // // Playlist 객체에 새로운 문자열을 생성하여 대입한다.
        playlist2.addSong(havana);
        //playlist2에 addSong 객체를 사용하여 대입
        playlist2.addSong(santaBaby);
        //playlist2에 addSong 객체를 사용하여 대입
        // 두 번째 재생목록을 만들고 여기에도 곡들을 추가
        PocuTunes tunes = new PocuTunes();
        // 마지막으로 PocuTunes 개체를 만든다.

        tunes.addSong(hotelCalifornia);
        //PocTune 개체에 addSong 개체를 사용해서 대입한다.
        tunes.addSong(heaven);
        //PocTune 개체에 addSong 개체를 사용해서 대입한다.
        tunes.addSong(havana);
        //PocTune 개체에 addSong 개체를 사용해서 대입한다.
        tunes.addSong(santaBaby);
        //PocTune 개체에 addSong 개체를 사용해서 대입한다.
        tunes.addSong(houndDog);
        //PocTune 개체에 addSong 개체를 사용해서 대입한다.
        tunes.addSong(basketCase);
        //PocTune 개체에 addSong 개체를 사용해서 대입한다.
        tunes.addSong(christmas);
        //PocTune 개체에 addSong 개체를 사용해서 대입한다.

        // 위에서 만들었던 7개 노래를 모두 추가한다.

        System.out.printf("Song count %d%s",
                tunes.getSongCount(),
                System.lineSeparator());
        //출력문, PocuTunes 개체에 getSongCout 개체를 대입 한 값을 출력한다.
        // 곡 수가 총 7인지 확인한다.

        tunes.addPlaylist(playlist1);
        //PocTune 개체에 addPlaylist 개체를 사용해서 대입한다.
        tunes.addPlaylist(playlist2);
        //PocTune 개체에 addPlaylist 개체를 사용해서 대입한다.
        //이제 두 재생목록을 추가하면 PocuTunes를 사용할 준비 끝

        tunes.playSong("Basket Case");
        //PocTune 개체에 PlaySong 개체를 사용해서 PocuTuns의 Class의 string songName에 대입한다.
        tunes.playSong("Hound Dog");
        //PocTune 개체에 PlaySong 개체를 사용해서 PocuTuns의 Class의 string songName에 대입한다.
        // 노래를 하나씩 플레이 할 때는 이렇게 함
        tunes.playSong("Escape");
        //PocTune 개체에 PlaySong 개체를 사용해서 PocuTuns의 Class의 string songName에 대입한다.
        //그러나 PocuTunes에 존재하지 않는 곡을 플레이하려고 하면 그 노래를 찾을 수 없다는 메시지가 등장

        tunes.playPlaylist("Classic Rock");
        //PocTune 개체에 PlaySong 개체를 사용해서 PocuTuns의 Class의 string playlistName에 대입한다.
        tunes.playPlaylist("Millenial");
        //PocTune 개체에 PlaySong 개체를 사용해서 PocuTuns의 Class의 string playlistName에 대입한다.
        //재생목록을 플레이하면 그 재생목록에 있는 노래만 플레이 된다.
       
        playlist2.setName("Christmas Music");
        //PocTune 개체에 PlaySong 개체를 사용해서 PocuTuns의 Class의 setName 개체에 대입한다.
        //'Millenial' 재생목록의 이름을 'Christmas Music'으로 바꿈
        playlist2.removeSong("Havana");
        //PocTune 개체에 PlaySong 개체와 PocuTuns의 Class의 removeSong개체를 사용해서 String songName에 대입한다.
        //'Havana'는 크리스마스 노래가 아니니 이 목록에서 제거
        playlist2.addSong(christmas);
        //PocTune 개체에 PlaySong 개체와 PocuTuns의 Class의 addSong개체를 사용해서 대입한다.
        // 그러나 'All I Want For Christmas Is You'는 크리스마스 노래이므로 'Christmas Music' 재생목록에 추가 할 수 있다.

        tunes.playPlaylist("Christmas Music");
        //PocTune 개체에 PlaySong 개체와 PocuTuns의 Class의 playPlaylist개체를 사용해서 playlistName에 대입한다.
        //'Christmas Music'을 플레이하면 Santa Baby, All I want For Christma is You가 플레이됨
        
        tunes.removeSong("Santa Baby");
        //PocTune 개체에 PlaySong 개체와 PocuTuns의 Class의 removeSong개체를 사용해서 songName에 대입한다.
        // PocuTunes로 부터 Santa Baby를 제거함
        tunes.playPlaylist("Christmas Music");
        //PocTune 개체에 PlaySong 개체와 PocuTuns의 Class의 playPlaylist개체를 사용해서 playlistName에 대입한다.
        // 'Christmas Music' 재생목록은 All I want For Christmas Is You만 플레이함, Santa Baby가 재생목록과 PocuTynes에 제거됨.
        tunes.playSong("Santa Baby");
        //PocTune 개체에 PlaySong 개체와 PocuTuns의 Class의 playsong개체를 사용해서 songName에 대입한다.
        // Santa Baby 곡을 플레이하려고 시도

        tunes.removePlaylist("Christmas Music");
        //PocTune 개체에 PlaySong 개체와 PocuTuns의 Class의 removePlaylist개체를 사용해서 playlistName에 대입한다.
        //재생목록을 지워도 PocuTunes에 있는 곡 수는 바뀌지 않음.

        System.out.printf("Song count %d.%s",
                tunes.getSongCount(),
                System.lineSeparator());
        //출력문, //PocTune 개체에 PocuTuns의 Class의 getSongCount 갸체의 정수와 문자열을 출력한다
        // 곡 수는 여전히 6개 (원래 7개였는데 위에서 Santa Baby를 지움)
        tunes.playPlaylist("Christmas Music");
        //PocTune 개체에 PlaySong 개체와 PocuTuns의 Class의 playPlaylist 개체를 사용해서 playlistName에 대입한다.
        // 그러나 'Christmas Music' 재생목록은 더 이상 찾을 수 없음
    }
}
