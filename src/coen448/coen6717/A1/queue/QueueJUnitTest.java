package coen448.coen6717.A1.queue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class QueueJUnitTest {
	
	private ADTQueue<Integer> DQ1 = new DQueue<>();
	private ADTQueue<Integer> DQ2 = new DQueue<>();

	private ADTQueue<Integer> AQ1 = new AQueue<>();
	private ADTQueue<Integer> AQ2 = new AQueue<>();

	private ADTQueue<Integer> LQ1 = new LQueue<>();
	private ADTQueue<Integer> LQ2 = new LQueue<>();


	@BeforeEach
	void setUp() throws Exception {
		this.DQ1 = new DQueue<Integer>();
		this.DQ2 = new DQueue<Integer>();
		this.AQ1 = new AQueue<Integer>(15);
		this.AQ2 = new AQueue<Integer>(15);
		this.LQ1 = new LQueue<Integer>(15);
		this.LQ2 = new LQueue<Integer>();
	}

	// Test Function #1
    // Test type : Functional, blackbox
    // Input : <setRobotDirection() 1 1 1 1 1 1 1 1>
    // Description : Robot's direction can be accurately determined.
    // Expected output : <getRobotDirection() 0 1 2 3 0 1 2 3 0>
    // Tester : Nicholas Harris
    // Date : 9th February
	@Test
	public void testGeneral() {
		int temp;
		System.out.println(DQ2.length());

		DQ2.enqueue(10);
		DQ2.enqueue(20);
		DQ2.enqueue(15);
		assertEquals("< 10 20 15 >", DQ2.toString());
		
		while(DQ2.length() > 0) {
		  temp = DQ2.dequeue();
		  DQ1.enqueue(temp);
		}
		assertEquals("< >", DQ2.toString());
		assertEquals("< 10 20 15 >", DQ1.toString());
	}
	
	
	// Test Function #2
    // Test type : Functional, blackbox
    // Input : < -2, 10 >
    // Description : Test setting a negative value for the queue size, inserting an element, and dequeuing an element
    // Expected output : <NegativeArraySizeException, 0, 10 >
    // Tester : Nicholas Harris
    // Date : 18th February
	@Test
	public void testNegativeAQSize() {
		try {
			AQ2 = new AQueue<>(-2);
		} catch (NegativeArraySizeException e) {
			Exception exception = assertThrows(NegativeArraySizeException.class, () -> {
				AQ2 = new AQueue<>(-2);
			});
			assertEquals(exception.getMessage(), e.getMessage());
		}

		try {
			assertEquals(0, AQ2.length());
		} catch (ArithmeticException e) {
			Exception exception = assertThrows(ArithmeticException.class, () -> {
				AQ2.length();
			});
			assertEquals(exception.getMessage(), e.getMessage());
		}

		try {
			AQ1.enqueue(10);
		} catch (AssertionError ae) {
			AssertionError assertionError = assertThrows(AssertionError.class, () -> {
				AQ1.enqueue(10);
			});
			assertEquals(assertionError.getMessage(), ae.getMessage());
		}

		try {
			assertEquals(10, AQ1.dequeue());
		} catch (AssertionError ae) {
			AssertionError assertionError = assertThrows(AssertionError.class, () -> {
				AQ1.dequeue();
			});
			assertEquals(assertionError.getMessage(), ae.getMessage());
		}
	}

	// Test Function #3
	// Test type : Functional, blackbox
	// Input : < -1, null >
	// Description : Test setting -1 value for the queue size, inserting a null element, and dequeuing an element
	// Expected output : <ArithmeticException, null >
	// Tester : Nicholas Harris
	// Date : 18th February
	@Test
	public void testZeroAQSize() {
		try {
			AQ2 = new AQueue<>(-1);
		} catch (NegativeArraySizeException e) {
			Exception exception = assertThrows(NegativeArraySizeException.class, () -> {
				AQ2 = new AQueue<>(-1);
			});
			assertEquals(exception.getMessage(), e.getMessage());
		}

		try {
			assertEquals(-1, AQ2.length());
		} catch (ArithmeticException e) {
			Exception exception = assertThrows(ArithmeticException.class, () -> {
				AQ2.length();
			});
			assertEquals(exception.getMessage(), e.getMessage());
		}

		try {
			AQ1.enqueue(null);
		} catch (AssertionError ae) {
			AssertionError assertionError = assertThrows(AssertionError.class, () -> {
				AQ1.enqueue(null);
			});
			assertNotEquals("Queue is full", ae.getMessage()); // fails if we get here
		}

		try {
			assertEquals(null, AQ1.dequeue());
		} catch (AssertionError ae) {
			assertNotEquals("Queue is empty", ae.getMessage());  // fails if we get here
		}
	}

	// Test Function #4
	// Test type : Functional, blackbox
	// Input : < 8, 1, 2, 3, 4 >
	// Description : Test setting a positive value for the queue size, and dequeuing an element while it is empty, inserting 4 elements
	// Expected output : <"Queue is empty" >
	// Tester : Nicholas Harris
	// Date : 18th February
	@Test
	public void testPositiveAQSize() {
		AQ2 = new AQueue<>(8);

		try {
			assertEquals("Queue is empty", AQ1.dequeue());
		} catch (AssertionError ae) {
			assertEquals("Queue is empty", ae.getMessage());
		}

		try {
			AQ2.enqueue(1);
			AQ2.enqueue(2);
			AQ2.enqueue(3);
			AQ2.enqueue(4);
		} catch (AssertionError ae) {
			assertNotEquals("Queue is full", ae.getMessage()); // fail if this occurs
		}
	}

	// Test Function #5
	// Test type : Functional, blackbox
	// Input : <1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 >
	// Description : Test setting no value for the queue size, and dequeuing an element while it is empty, inserting 11 elements
	// Expected output : < "Queue is empty", "Queue is full" >
	// Tester : Nicholas Harris
	// Date : 18th February
	@Test
	public void testNoAQSize() {
		AQ2 = new AQueue<>();

		try {
			assertEquals("Queue is empty", AQ1.dequeue());
		} catch (AssertionError ae) {
			assertEquals("Queue is empty", ae.getMessage());
		}

		try {
			AQ2.enqueue(1);
			AQ2.enqueue(2);
			AQ2.enqueue(3);
			AQ2.enqueue(4);
			AQ2.enqueue(5);
			AQ2.enqueue(6);
			AQ2.enqueue(7);
			AQ2.enqueue(8);
			AQ2.enqueue(9);
			AQ2.enqueue(10);
		} catch (AssertionError ae) {
			assertNotEquals("Queue is full", ae.getMessage());
		}

		AssertionError assertionError = assertThrows(AssertionError.class, () -> {
			AQ2.enqueue(11);
		});

		assertEquals("Queue is full", assertionError.getMessage());
	}

	// Test Function #6
	// Test type : Functional, blackbox
	// Input : < 10, 11, 10, 12 >
	// Description : Test inserting elements to dqueue, dequeueing elements from dqueue
	// Expected output : < 11 10 12 >
	// Tester : Nicholas Harris
	// Date : 18th February
	@Test
	public void testDQEnqueue() {
		DQ2.enqueue(10);
		DQ2.enqueue(11);
		DQ2.enqueue(10);
		DQ2.enqueue(12);

		assertEquals(10, DQ2.dequeue());

		assertEquals("< 11 10 12 >", DQ2.toString());
	}

	// Test Function #7
	// Test type : Functional, blackbox
	// Input : < null >
	// Description : Test inserting null element to dqueue, and dequeueing from empty dqueue
	// Expected output : < null >
	// Tester : Nicholas Harris
	// Date : 18th February
	@Test
	public void testDQEnqueueNull() {
		DQ2.enqueue(null);

		assertEquals(null, DQ2.dequeue());

		try {
			DQ2.dequeue();
		} catch (NullPointerException e) {
			Exception exception = assertThrows(NullPointerException.class, () -> {
				DQ2.dequeue();
			});

			assertEquals(exception.getMessage(), e.getMessage());
		}
	}

	// Test Function #8
	// Test type : Functional, blackbox
	// Input : < -2, 10 >
	// Description : Test setting a negative value for the queue size, inserting an element, and dequeuing an element
	// Expected output : <0, 10 >
	// Tester : Nicholas Harris
	// Date : 18th February
	@Test
	public void testNegativeLQSize() {
		try {
			LQ2 = new LQueue<>(-2);
		} catch (NegativeArraySizeException e) {
			Exception exception = assertThrows(NegativeArraySizeException.class, () -> {
				LQ2 = new LQueue<>(-2);
			});
			assertNotEquals(exception.getMessage(), e.getMessage());
		}

		assertEquals(0, LQ2.length());

		LQ2.enqueue(10);

		try {
			assertEquals(10, LQ2.dequeue());
		} catch (AssertionError ae) {
			assertNotEquals("Queue is empty", ae.getMessage());
		}
	}

	// Test Function #9
	// Test type : Functional, blackbox
	// Input : < -1, null >
	// Description : Test setting -1 value for the queue size, inserting a null element, and dequeuing an element
	// Expected output : <0, null >
	// Tester : Nicholas Harris
	// Date : 18th February
	@Test
	public void testZeroLQSize() {
		try {
			LQ1 = new LQueue<>(-1);
		} catch (NegativeArraySizeException e) {
			Exception exception = assertThrows(NegativeArraySizeException.class, () -> {
				LQ1 = new LQueue<>(-1);
			});
			assertNotEquals(exception.getMessage(), e.getMessage());
		}

		assertEquals(0, LQ1.length());

		LQ1.enqueue(null);

		try {
			assertEquals(null, LQ1.dequeue());
		} catch (AssertionError ae) {
			assertNotEquals("Queue is empty", ae.getMessage());  // fails if we get here
		}

		AssertionError assertionError = assertThrows(AssertionError.class, () -> {
			LQ1.dequeue();
		});

		assertEquals("Queue is empty", assertionError.getMessage());
	}

	// Test Function #10
	// Test type : Functional, blackbox
	// Input : < 8, 1, 2, 3, 4 >
	// Description : Test setting a positive value for the queue size, inserting 4 elements and dequeuing one element
	// Expected output : <"Queue is empty" >
	// Tester : Nicholas Harris
	// Date : 18th February
	@Test
	public void testPositiveLQSize() {
		LQ2 = new LQueue<>(21);

		AssertionError assertionError = assertThrows(AssertionError.class, () -> {
			LQ2.dequeue();
		});

		assertEquals("Queue is empty", assertionError.getMessage());

		LQ1.enqueue(15);
		LQ1.enqueue(22);
		LQ1.enqueue(33);
		LQ1.enqueue(44);

		assertEquals(15, LQ1.dequeue());

		assertEquals("< 22 33 44 >", LQ1.toString());
	}

	// Test Function #11
	// Test type : Functional, blackbox
	// Input : <15 22 33 44 >
	// Description : Test setting no value for the queue size, and inserting elements, dequeueing elements
	// Expected output : < < 15 22 33 44 >, < >, < 15 22 33 44 >, < 15 >, < 22 33 44 >>
	// Tester : Nicholas Harris
	// Date : 18th February
	@Test
	public void testNoLQSize() {
		LQ2.enqueue(15);
		LQ2.enqueue(22);
		LQ2.enqueue(33);
		LQ2.enqueue(44);

		assertEquals("< 15 22 33 44 >", LQ2.toString());

		while(LQ2.length() > 0) {
			int temp = LQ2.dequeue();
			LQ1.enqueue(temp);
		}

		assertEquals("< >", LQ2.toString());
		assertEquals("< 15 22 33 44 >", LQ1.toString());

		LQ2.enqueue(LQ1.dequeue());
		assertEquals("< 15 >", LQ2.toString());
		assertEquals("< 22 33 44 >", LQ1.toString());
	}
}
