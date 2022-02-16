package edu.wctc;


import java.io.Serializable;
import java.util.ArrayList;
//import java.util.Collections;
import java.util.List;

public class PaintCalculator implements Serializable {

   private List<Room> roomList = new ArrayList<>();

   public void addRoom(double length, double width, double height){
      //List<Room> roomList = new ArrayList<>();
      Room room = new Room(length,width,height);
      roomList.add(room);
   }
   public String toString() {
      StringBuilder roomArea = new StringBuilder();
      if (!roomList.isEmpty()) {
         for (Room room : roomList) {
             roomArea.append(room.toString());
             roomArea.append("\n");
         }
         return roomArea.toString();
      }
      return "There is no Room yet";
   }
}
