package mediabiblioteket;

import static org.junit.Assert.*;

import org.junit.Test;
import collections.LinkedList;
import java.util.ArrayList;
//import java.util.LinkedList;

public class LibraryControllerTest {
	
	

	@Test
	public void checkIfBorrowerExistsTest() {
		
		//Arrange
		LibraryController libraryController = new LibraryController();
		
		//Act
		boolean doesExist = libraryController.checkIfBorrowerExist("361025-2222");
		
		//Assert
		assertEquals(true, doesExist);
	}
	
	@Test
	public void checkIfBorrowerDoesntExistTest()
	{
		//Arrange
		LibraryController libraryController = new LibraryController();
		
		//Act
		boolean doesNotExist = libraryController.checkIfBorrowerExist("666");
		
		//Assert
		assertEquals(false, doesNotExist);
	}
	
	@Test
	public void showSelectedMediaInfoTest()
	{
		//Arrange
		LibraryController libraryController = new LibraryController(new GUI());
		Book book1 = new Book("Bok", "Agenten", "123456", 2005, "Grisham");
		book1.setBorrowed(true);
		//System.out.println(libraryController.mediaSearchResults);
		String testData = "Bok - Borrowed\n - Agenten - 2005 - Grisham";
		
		//Act
		libraryController.searchMediaAllByString("Agenten");
		//System.out.println(libraryController.mediaSearchResults);
		
		//Assert
		libraryController.showSelectedMediaInfo(testData);
	}
	
	@Test
	public void searchMediaTitleByStringTest() //Går EJ att köra utan kodändring
	{
		//Arrange
		LibraryController libraryController = new LibraryController();
		String theSearchString = "Sin";
		
		//Act
		libraryController.searchMediaTitleByString(theSearchString);
		
		//Assert
		//För att kolla om det funkar ändrade jag om if satsen i searchMediaTitleByString till:
		
		//if (tempSearch.getTitle().toLowerCase().contains(theSearchString.toLowerCase()))
		//{
		//	mediaSearchResults.add(tempSearch);
		//	//theGUI.setTheTextArea(tempSearch.toString());
		//	System.out.print("Test passed!");
		//}
		//Glöm inte att ändra tillbaka ;)
		
	}
	
	@Test
	public void searchMediaTitleByStringTestFail() //Går EJ att köra utan kodändring
	{
		//Arrange
		LibraryController libraryController = new LibraryController();
		String theSearchString = "garrrhh";
		
		//Act
		libraryController.searchMediaTitleByString(theSearchString);
		
		//Assert
		//För att kolla om det funkar ändrade jag om if satsen i searchMediaTitleByString till:
		
		//if (tempSearch.getTitle().toLowerCase().contains(theSearchString.toLowerCase()))
		//{
		//	mediaSearchResults.add(tempSearch);
		//	//theGUI.setTheTextArea(tempSearch.toString());
		//	System.out.print("Test passed!");
		//}
		//Glöm inte att ändra tillbaka ;)
		
		//I detta fallet failar den och println nås inte. Inget skrivs ut.
		
	}
	
	@Test
	public void CreateBookTest()
	{
		//Arrange
		Book book1 = new Book("Bok", "Unit Test for Aliens", "000001", 2023, "Buzz Armstrong");
		String expectedAuthor = "Buzz Armstrong";
		String info = "";
		
		//Act
		String actualAuthor = book1.getAuthor();
		
		//Assert
		assertEquals(expectedAuthor, actualAuthor);
	}
	
	@Test
	public void CreateDVDTest()
	{
		//Arrange
		LibraryController libraryController = new LibraryController();
		LinkedList<String> actors = new LinkedList<String>();
		actors.add("The Hero");
		actors.add("The Romantic Interest");
		actors.add("The Bad Guy");
		
		//Act
		DVD theMovie = new DVD("DVD", "The Summer Hit", "111111", 2017, actors);
		LinkedList<String> expectedActors = new LinkedList<String>();
		expectedActors = theMovie.getActors();
		
		//Assert
		assertEquals(expectedActors, actors);
	}
}
