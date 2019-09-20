package mediabiblioteket;

import static org.junit.Assert.*;

import org.junit.Test;

public class LibraryControllerTest {

	@Test
	public void checkIfBorrowerExistsTest() {
		
		LibraryController libraryController = new LibraryController();
		
		boolean doesExist = libraryController.checkIfBorrowerExist("361025-2222");
		assertEquals(true, doesExist);
	}
	
	@Test
	public void checkIfBorrowerDoesntExistTest()
	{
		LibraryController libraryController = new LibraryController();
		
		boolean doesNotExist = libraryController.checkIfBorrowerExist("666");
		assertEquals(false, doesNotExist);
	}
	
	@Test
	public void searchMediaTitleByStringTest()
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
	public void searchMediaTitleByStringTestFail()
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

}
