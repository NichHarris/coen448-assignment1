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

	/*
		Each Choice Coverage (ECC)
	 */

	// Test Function #1
    // Test type : Structural, white-box
    // Input : < -2, 10 >
    // Description : Test setting a negative value for the queue size, inserting an element, and dequeue an element
    // Expected output : <NegativeArraySizeException, 0, 10 >
    // Tester : Nicholas Harris, Matthew Sklivas
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

	// Test Function #2
	// Test type : Structural, white-box
	// Input : < -1, null >
	// Description : Test setting -1 value for the queue size, inserting a null element, and dequeue an element
	// Expected output : <ArithmeticException, null >
	// Tester : Nicholas Harris, Matthew Sklivas
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

	// Test Function #3
	// Test type : Structural, white-box
	// Input : < 8, 1, 2, 3, 4 >
	// Description : Test setting a positive value for the queue size, and dequeue an element while it is empty, inserting 4 elements
	// Expected output : <"Queue is empty" >
	// Tester : Nicholas Harris, Matthew Sklivas
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

	// Test Function #4
	// Test type : Structural, white-box
	// Input : <1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 >
	// Description : Test setting no value for the queue size, and dequeue an element while it is empty, inserting 11 elements
	// Expected output : < "Queue is empty", "Queue is full" >
	// Tester : Nicholas Harris, Matthew Sklivas
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

	// Test Function #5
	// Test type : Structural, white-box
	// Input : < 10, 11, 10, 12 >
	// Description : Test inserting elements to dqueue, dequeue elements from dqueue
	// Expected output : < 11 10 12 >
	// Tester : Nicholas Harris, Matthew Sklivas
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

	// Test Function #6
	// Test type : Structural, white-box
	// Input : < null >
	// Description : Test inserting null element to dqueue, and dequeue from empty dqueue
	// Expected output : < null >
	// Tester : Nicholas Harris, Matthew Sklivas
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

	// Test Function #7
	// Test type : Structural, white-box
	// Input : < -2, 10 >
	// Description : Test setting a negative value for the queue size, inserting an element, and dequeuing an element
	// Expected output : <0, 10 >
	// Tester : Nicholas Harris, Matthew Sklivas
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

	// Test Function #8
	// Test type : Structural, white-box
	// Input : < -1, null >
	// Description : Test setting -1 value for the queue size, inserting a null element, and dequeuing an element
	// Expected output : <0, null, "Queue is empty" >
	// Tester : Nicholas Harris, Matthew Sklivas
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

	// Test Function #9
	// Test type : Structural, white-box
	// Input : < 8, 1, 2, 3, 4 >
	// Description : Test setting a positive value for the queue size, inserting 4 elements and dequeuing one element
	// Expected output : < "Queue is empty", "< 22 33 44 >" >
	// Tester : Nicholas Harris, Matthew Sklivas
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

	// Test Function #10
	// Test type : Structural, white-box
	// Input : <15 22 33 44 >
	// Description : Inserting elements, dequeue elements
	// Expected output : < < 15 22 33 44 >, < >, < 15 22 33 44 >, < 15 >, < 22 33 44 >>
	// Tester : Nicholas Harris, Matthew Sklivas
	// Date : 18th February
	@Test
	public void testValueEnqueue() {
		assertEquals(0, LQ2.length());

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

	// Test Function #8
	// Test type : Functional, blackbox
	// Input : < null >
	// Description : inserting a null element, and dequeue an element from empty.
	// Expected output : <0, null, "Queue is empty" >
	// Tester : Nicholas Harris
	// Date : 18th February
	@Test
	public void testNullEnqueue() {
		assertEquals(0, LQ1.length());

		AssertionError assertionError = assertThrows(AssertionError.class, () -> {
			LQ1.dequeue();
		});

		assertEquals("Queue is empty", assertionError.getMessage());

		LQ1.enqueue(null);

		try {
			assertEquals(null, LQ1.dequeue());
		} catch (AssertionError ae) {
			assertNotEquals("Queue is empty", ae.getMessage());  // fails if we get here
		}
	}

	/*
		Base Choice Coverage (BCC)
	*/

	// Test Function #11
	// Test type : Structural, white-box
	// Input : <15 15 15 16>
	// Description : Test setting positive value for the queue size, and inserting elements, dequeue elements
	// Expected output : < 1, 3, 15, 2, < 15 16 >>
	// Tester : Nicholas Harris, Matthew Sklivas
	// Date : 18th February
	@Test
	public void testAQBase() {
		AQ1 = new AQueue<>(15);

		AQ1.enqueue(15);
		assertEquals(1, AQ1.length());

		AQ1.enqueue(15);
		AQ1.enqueue(16);

		assertEquals(3, AQ1.length());
		assertEquals(15, AQ1.dequeue());
		assertEquals(2, AQ1.length());
		assertEquals("< 15 16 >", AQ1.toString());
	}

		/*
		Block Choice Coverage (BCC)
	*/

	// Test Function #12
	// Test type : Structural, white-box
	// Input : <2 15 15 16 >
	// Description : Test setting positive value for the queue size, and inserting elements until queue is full, dequeue elements
	// Expected output : < 1, 2, Queue is full, 2, 15, 1, < 15 >>
	// Tester : Nicholas Harris, Matthew Sklivas
	// Date : 18th February
	// BUG REPORT: Index out of bounds when printing array contents after a dequeue
	@Test
	public void testAQ2() {
		AQ1 = new AQueue<>(2);

		AQ1.enqueue(15);
		assertEquals(1, AQ1.length());

		AQ1.enqueue(15);

		assertEquals(2, AQ1.length());

		AssertionError assertionError = assertThrows(AssertionError.class, () -> {
			AQ1.enqueue(16);
		});

		assertEquals("Queue is full", assertionError.getMessage());

		assertEquals(2, AQ1.length());
		assertEquals(15, AQ1.dequeue());
		assertEquals(1, AQ1.length());
		assertEquals("< 15 >", AQ1.toString());
	}

	// Test Function #13
	// Test type : Structural, white-box
	// Input : <10 15 >
	// Description : Test setting positive value for the queue size, and inserting elements, dequeue elements form empty queue
	// Expected output : < 0, Queue is empty, < 15 >>
	// Tester : Nicholas Harris, Matthew Sklivas
	// Date : 18th February
	@Test
	public void testAQ3() {
		AQ1 = new AQueue<>(10);

		assertEquals(0, AQ1.length());

		AssertionError assertionError = assertThrows(AssertionError.class, () -> {
			AQ1.dequeue();
		});

		assertEquals("Queue is empty", assertionError.getMessage());

		AQ1.enqueue(15);
		assertEquals("< 15 >", AQ1.toString());
	}

	// Test Function #14
	// Test type : Structural, white-box
	// Input : <10 null null null>
	// Description : Test setting positive value for the queue size, and inserting null elements, dequeue elements
	// Expected output : < < null null null >, null, < null null >>
	// Tester : Nicholas Harris, Matthew Sklivas
	// Date : 18th February
	@Test
	public void testAQ4() {
		AQ1 = new AQueue<>(10);

		AQ1.enqueue(null);
		AQ1.enqueue(null);
		AQ1.enqueue(null);

		assertEquals("< null null null >", AQ1.toString());
		assertEquals(null, AQ1.dequeue());
		assertEquals("< null null >", AQ1.toString());
	}

	// Test Function #15
	// Test type : Structural, white-box
	// Input : <-10 11 44 22 33>
	// Description : Test setting negative value for the queue size, and inserting elements, dequeue elements
	// Expected output : < NegativeArraySizeException, 4, < 11 44 22 33 >, 11, < 44 22 33 >>
	// Tester : Nicholas Harris, Matthew Sklivas
	// Date : 18th February
	@Test
	public void testAQ5() {
		try {
			AQ2 = new AQueue<>(-10);
		} catch (NegativeArraySizeException e) {
			Exception exception = assertThrows(NegativeArraySizeException.class, () -> {
				AQ2 = new AQueue<>(-10);
			});
			assertEquals(exception.getMessage(), e.getMessage());
		}

		AQ2.enqueue(11);
		AQ2.enqueue(44);
		AQ2.enqueue(22);
		AQ2.enqueue(33);
		assertEquals(4, AQ2.length());
		assertEquals("< 11 44 22 33 >", AQ2.toString());
		assertEquals(11, AQ2.dequeue());
		assertEquals("< 44 22 33 >", AQ2.toString());
	}

	// Test Function #16
	// Test type : Structural, white-box
	// Input : <-1 11 44 22 33>
	// Description : Test setting -1 value for the queue size, and inserting elements, dequeue elements
	// Expected output : < ArithmeticException, 4, < 11 44 22 33 >, 11, < 44 22 33 >>
	// Tester : Nicholas Harris, Matthew Sklivas
	// Date : 18th February
	@Test
	public void testAQ6() {
		AQ2 = new AQueue<>(-1);

		try {
			AQ2.length();
		} catch (ArithmeticException e) {
			Exception exception = assertThrows(ArithmeticException.class, () -> {
				AQ2.length();
			});
			assertEquals(exception.getMessage(), e.getMessage());
		}

		AQ1.enqueue(11);
		AQ1.enqueue(44);
		AQ1.enqueue(22);
		AQ1.enqueue(33);
		assertEquals(4, AQ1.length());
		assertEquals("< 11 44 22 33 >", AQ1.toString());
		assertEquals(11, AQ1.dequeue());
		assertEquals("< 44 22 33 >", AQ1.toString());
	}

	// Test Function #17
	// Test type : Structural, white-box
	// Input : <234 -34 22 -3>
	// Description : Test setting no value for the queue size, and inserting elements, dequeue elements
	// Expected output : < 0, 4, < 234 -34 22 -3 >, 234, < -34 22 -3  >>
	// Tester : Nicholas Harris, Matthew Sklivas
	// Date : 18th February
	@Test
	public void testAQ7() {
		AQ2 = new AQueue<>();

		assertEquals(0, AQ2.length());

		AQ2.enqueue(234);
		AQ2.enqueue(-34);
		AQ2.enqueue(22);
		AQ2.enqueue(-3);
		assertEquals(4, AQ2.length());
		assertEquals("< 234 -34 22 -3 >", AQ2.toString());
		assertEquals(234, AQ2.dequeue());
		assertEquals("< -34 22 -3 >", AQ2.toString());
	}

	// Test Function #18
	// Test type : Structural, white-box
	// Input : <10 15>
	// Description : Test inserting elements, dequeue elements
	// Expected output : < 1, 10, < 15 >>
	// Tester : Nicholas Harris, Matthew Sklivas
	// Date : 18th February
	@Test
	public void testDQBase() {
		DQ1.enqueue(10);
		assertEquals(1, DQ1.length());
		DQ1.enqueue(15);
		assertEquals(10, DQ1.dequeue());

		assertEquals("< 15 >", DQ1.toString());
	}

	// Test Function #19
	// Test type : Structural, white-box
	// Input : <10>
	// Description : Test inserting elements, dequeue elements, dequeue from empty queue
	// Expected output : < 1, 10, NullPointerException >
	// Tester : Nicholas Harris, Matthew Sklivas
	// Date : 18th February
	@Test
	public void testDQ2() {
		DQ1.enqueue(10);
		assertEquals(1, DQ1.length());
		assertEquals(10, DQ1.dequeue());

		try {
			DQ1.dequeue();
		} catch (NullPointerException e) {
			Exception exception = assertThrows(NullPointerException.class, () -> {
				DQ1.dequeue();
			});
			assertEquals(exception.getMessage(), e.getMessage());
		}
	}

	// Test Function #20
	// Test type : Structural, white-box
	// Input : <null>
	// Description : Test inserting null element, dequeue element
	// Expected output : < 1, null, 0, <>>
	// Tester : Nicholas Harris, Matthew Sklivas
	// Date : 18th February
	@Test
	public void testDQ3() {
		DQ1.enqueue(null);
		assertEquals(1, DQ1.length());
		assertEquals(null, DQ1.dequeue());
		assertEquals(0, DQ1.length());
		assertEquals("< >", DQ1.toString());
	}

	// Test Function #21
	// Test type : Structural, white-box
	// Input : <3, 10, 15, 15, 20, 11>
	// Description : Test setting queue size, inserting elements, dequeueing elements
	// Expected output : < 5, 10, 4, < 15 15 20 11 >>
	// Tester : Nicholas Harris, Matthew Sklivas
	// Date : 18th February
	@Test
	public void testLQBase() {
		LQ1.enqueue(10);
		LQ1.enqueue(15);
		LQ1.enqueue(15);
		LQ1.enqueue(20);
		LQ1.enqueue(11);

		assertEquals(5, LQ1.length());
		assertEquals(10, LQ1.dequeue());
		assertEquals(4, LQ1.length());
		assertEquals("< 15 15 20 11 >", LQ1.toString());
	}

	// Test Function #22
	// Test type : Structural, white-box
	// Input : <15, 23>
	// Description : Test setting queue size, inserting elements, dequeueing elements, dequeing from empty queue
	// Expected output : < "Queue is empty", 1, 23, 0, < >>
	// Tester : Nicholas Harris, Matthew Sklivas
	// Date : 18th February
	@Test
	public void testLQ2() {
		AssertionError assertionError = assertThrows(AssertionError.class, () -> {
			LQ1.dequeue();
		});

		assertEquals("Queue is empty", assertionError.getMessage());

		LQ1.enqueue(23);

		assertEquals(1, LQ1.length());
		assertEquals(23, LQ1.dequeue());
		assertEquals(0, LQ1.length());
		assertEquals("< >", LQ1.toString());
	}

	// Test Function #23
	// Test type : Structural, white-box
	// Input : <15, null, null >
	// Description : Test setting queue size, inserting null elements, dequeueing null elements
	// Expected output : < 2, null, < null >>
	// Tester : Nicholas Harris, Matthew Sklivas
	// Date : 18th February
	@Test
	public void testLQ3() {
		LQ1.enqueue(null);
		LQ1.enqueue(null);

		assertEquals(2, LQ1.length());
		assertEquals(null, LQ1.dequeue());
		assertEquals("< null >", LQ1.toString());
	}

	// Test Function #24
	// Test type : Structural, white-box
	// Input : <-10, 22, 33 >
	// Description : Test setting negative queue size, inserting null elements, dequeueing null elements
	// Expected output : < 2, 22, < 33 >>
	// Tester : Nicholas Harris, Matthew Sklivas
	// Date : 18th February
	@Test
	public void testLQ4() {
		LQ1 = new LQueue<>(-10);

		LQ1.enqueue(22);
		LQ1.enqueue(33);

		assertEquals(2, LQ1.length());
		assertEquals(22, LQ1.dequeue());
		assertEquals("< 33 >", LQ1.toString());
	}

	// Test Function #25
	// Test type : Structural, white-box
	// Input : <-1, 22, 33 >
	// Description : Test setting -1 queue size, inserting null elements, dequeueing null elements
	// Expected output : < 2, 22, < 33 >>
	// Tester : Nicholas Harris, Matthew Sklivas
	// Date : 18th February
	@Test
	public void testLQ5() {
		LQ1 = new LQueue<>(-1);

		LQ1.enqueue(22);
		LQ1.enqueue(33);

		assertEquals(2, LQ1.length());
		assertEquals(22, LQ1.dequeue());
		assertEquals("< 33 >", LQ1.toString());
	}

	// Test Function #26
	// Test type : Structural, white-box
	// Input : < 22, 33 >
	// Description : Test no queue size, inserting null elements, dequeueing null elements
	// Expected output : < 2, 22, < 33 >>
	// Tester : Nicholas Harris, Matthew Sklivas
	// Date : 18th February
	@Test
	public void testLQ6() {
		LQ1 = new LQueue<>();

		LQ1.enqueue(22);
		LQ1.enqueue(33);

		assertEquals(2, LQ1.length());
		assertEquals(22, LQ1.dequeue());
		assertEquals("< 33 >", LQ1.toString());
	}
}
