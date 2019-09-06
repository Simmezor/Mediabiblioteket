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

}
