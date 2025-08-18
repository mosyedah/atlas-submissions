package day25;

//Implementor
interface TV {
 void on();
}

//Concrete Implementors
class SonyTV implements TV {
 public void on() {
     System.out.println("Sony TV is ON");
 }
}

class SamsungTV implements TV {
 public void on() {
     System.out.println("Samsung TV is ON");
 }
}

//Abstraction
abstract class RemoteControl {
 protected TV tv;  // bridge
 public RemoteControl(TV tv) {
     this.tv = tv;
 }
 public abstract void pressOnButton();
}

//Refined Abstraction
class BasicRemote extends RemoteControl {
 public BasicRemote(TV tv) {
     super(tv);
 }
 public void pressOnButton() {
     tv.on();
 }
}

//Client
public class HomeTask05_BridgeExample {
 public static void main(String[] args) {
     RemoteControl remote1 = new BasicRemote(new SonyTV());
     RemoteControl remote2 = new BasicRemote(new SamsungTV());

     remote1.pressOnButton();
     remote2.pressOnButton();
 }
}

