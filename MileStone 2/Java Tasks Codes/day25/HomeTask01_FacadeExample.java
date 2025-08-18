package day25;


//Subsystem classes
class DVDPlayer {
 void on() { System.out.println("DVD Player ON"); }
 void play(String movie) { System.out.println("Playing " + movie); }
}

class Amplifier {
 void on() { System.out.println("Amplifier ON"); }
 void setVolume(int level) { System.out.println("Volume set to " + level); }
}

class Projector {
 void on() { System.out.println("Projector ON"); }
}

//Facade
class HomeTheaterFacade {
 private DVDPlayer dvd;
 private Amplifier amp;
 private Projector projector;

 public HomeTheaterFacade(DVDPlayer dvd, Amplifier amp, Projector projector) {
     this.dvd = dvd;
     this.amp = amp;
     this.projector = projector;
 }

 public void watchMovie(String movie) {
     System.out.println("Get ready to watch a movie...");
     amp.on();
     amp.setVolume(5);
     projector.on();
     dvd.on();
     dvd.play(movie);
 }
}

//Client
public class HomeTask01_FacadeExample {
 public static void main(String[] args) {
     DVDPlayer dvd = new DVDPlayer();
     Amplifier amp = new Amplifier();
     Projector projector = new Projector();

     HomeTheaterFacade homeTheater = new HomeTheaterFacade(dvd, amp, projector);
     homeTheater.watchMovie("Inception");
 }
}
