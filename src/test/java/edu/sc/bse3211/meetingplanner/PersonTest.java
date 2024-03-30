package edu.sc.bse3211.meetingplanner;

import static org.junit.Assert.*;
import org.junit.Test;

public class PersonTest {
	// Add test methods here. 
    // You are not required to write tests for all classes.

@Test
public void testCreatePersonWithName(){
    Person person=new Person("Haulah");
    assertEquals("Haulah",person.getName());
    assertNotNull(person);
}
@Test
public void testCreatePerson(){
Person person=new Person();
assertNotNull(person);
}

@Test
public void testAddingMeetingAtIndex() throws TimeConflictException {
    
    Person person = new Person("Haulah");
    
    // Creating a meeting and add it to the Person's calendar
    Meeting meeting = new Meeting(10, 1, 1, 3);
    person.addMeeting(meeting);
    
    // meeting at index 0 exists
    assertNotNull(person.getMeeting(10, 1, 0));
}

    @Test
    public void testPrintAgendaMonth() throws TimeConflictException {
        Person person = new Person("Haulah"); 
        Meeting meeting = new Meeting(10, 1, 1, 3);
        Room room = new Room("Room 1");
        meeting.setRoom(room);
        person.addMeeting(meeting);
        assertNotNull(person.printAgenda(12));
    }
    
    @Test
    public void testPrintAgendaMonthDay() throws TimeConflictException {
        Person person = new Person("Haulah"); 
        Meeting meeting = new Meeting(10, 1, 1, 3);
        Room room = new Room("Room 1");
        meeting.setRoom(room);
        person.addMeeting(meeting);
        assertNotNull(person.printAgenda(12, 1));
    }
    
    @Test
    public void testIsBusy() throws TimeConflictException {
        Person person = new Person("Haulah"); 
        Meeting meeting = new Meeting(10, 1, 1, 3);
        Room room = new Room("Room 1");
        meeting.setRoom(room);
        person.addMeeting(meeting);
        assertTrue(person.isBusy(10, 1, 1, 3));
    }
    
    @Test
    public void testRemoveMeeting() throws TimeConflictException {
        Person person = new Person("Haulah"); 
        Meeting meeting = new Meeting(10, 1, 1, 3);
        person.addMeeting(meeting);
        assertNotNull(person.getMeeting(10, 1, 0));
        person.removeMeeting(10, 1, 0);
        try {
            person.getMeeting(35, 2, 0); //35th February
            fail("Expected IndexOutOfBoundsException was not thrown.");
        } catch (IndexOutOfBoundsException ignored) {
            // Expected exception
        }
    }
}

