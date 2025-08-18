package day26;

//Command interface
interface Command {
 void execute();
}

//Receiver
class Light {
 public void turnOn() {
     System.out.println("Light is ON");
 }
 public void turnOff() {
     System.out.println("Light is OFF");
 }
}

//Concrete Commands
class LightOnCommand implements Command {
 private Light light;
 public LightOnCommand(Light light) { this.light = light; }
 @Override
 public void execute() { light.turnOn(); }
}

class LightOffCommand implements Command {
 private Light light;
 public LightOffCommand(Light light) { this.light = light; }
 @Override
 public void execute() { light.turnOff(); }
}

//Invoker
class RemoteControl {
 private Command command;
 public void setCommand(Command command) { this.command = command; }
 public void pressButton() { command.execute(); }
}

//Client
public class HomeTask02_CommandPattern {
 public static void main(String[] args) {
     Light livingRoomLight = new Light();

     Command lightsOn = new LightOnCommand(livingRoomLight);
     Command lightsOff = new LightOffCommand(livingRoomLight);

     RemoteControl remote = new RemoteControl();

     // Turn light on
     remote.setCommand(lightsOn);
     remote.pressButton();

     // Turn light off
     remote.setCommand(lightsOff);
     remote.pressButton();
 }
}
