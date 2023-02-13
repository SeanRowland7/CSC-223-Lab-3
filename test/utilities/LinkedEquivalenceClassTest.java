package utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

class LinkedEquivalenceClassTest 
{

	
	@Test
	void canonicalTest() 
	{
		Comparator<Integer> c1 = new Comparator<Integer>()  
		{
			// All even integers are 'equivalent' 
			public int compare(Integer x, Integer y) { return x % 2 == y % 2 ? 0 : 1; } 
		};
		
		LinkedEquivalenceClass<Integer> eq1 = new LinkedEquivalenceClass<Integer>(c1);
			
		eq1.add(1);
		eq1.add(2);	
		eq1.add(3);	
		assertEquals("{1 | 3}", eq1.toString());
		assertEquals(1, eq1.canonical());
		
		eq1.demoteAndSetCanonical(5);
		assertEquals("{5 | 1, 3}", eq1.toString());
		assertEquals(5, eq1.canonical());
		
		
		
		Comparator<String> c2 = new Comparator<String>()
		{
			// All Strings with same first character are 'equivalent'
			public int compare(String x, String y) 
			{ 
				if(x.length() == 0 || y.length() == 0) return 1;
				
				return x.charAt(0) == y.charAt(0) ? 0 : 1; 
			}
		};
		
		LinkedEquivalenceClass<String> eq2 = new LinkedEquivalenceClass<String>(c2);
																				
		eq2.add("apple");	
		eq2.add("bin");	
		eq2.add("air");	
		eq2.add("answer");	
		
		assertEquals("{apple | answer, air}", eq2.toString());
		assertEquals("apple", eq2.canonical());
		
		eq2.demoteAndSetCanonical("cat");
		assertEquals("{apple | answer, air}", eq2.toString());
		assertEquals("apple", eq2.canonical());
		
		eq2.demoteAndSetCanonical("animal");
		assertEquals("{animal | apple, answer, air}", eq2.toString());
		assertEquals("animal", eq2.canonical());
	}

	@Test
	void isEmptyTest() 
	{
		Comparator<Integer> c1 = new Comparator<Integer>()  
		{
			// All even integers are 'equivalent' 
			public int compare(Integer x, Integer y) { return x % 2 == y % 2 ? 0 : 1; } 
		};
		
		LinkedEquivalenceClass<Integer> eq1 = new LinkedEquivalenceClass<Integer>(c1);
			
		assertTrue(eq1.isEmpty());
		eq1.add(1);
		eq1.add(2);	
		eq1.add(3);	
		assertFalse(eq1.isEmpty());
		assertEquals("{1 | 3}", eq1.toString());
		assertEquals(1, eq1.canonical());
		
		eq1.demoteAndSetCanonical(5);
		assertEquals("{5 | 1, 3}", eq1.toString());
		assertEquals(5, eq1.canonical());
		
		eq1.clearNonCanonical();
		assertFalse(eq1.isEmpty());
		
		eq1.removeCanonical();
		assertTrue(eq1.isEmpty());
		
		eq1.add(2);	
		assertFalse(eq1.isEmpty());
		eq1.clear();
		assertTrue(eq1.isEmpty());
		
		Comparator<String> c2 = new Comparator<String>()
		{
			// All Strings with same first character are 'equivalent'
			public int compare(String x, String y) 
			{ 
				if(x.length() == 0 || y.length() == 0) return 1;
				
				return x.charAt(0) == y.charAt(0) ? 0 : 1; 
			}
		};
		
		LinkedEquivalenceClass<String> eq2 = new LinkedEquivalenceClass<String>(c2);
																				
		eq2.add("apple");	
		eq2.add("bin");	
		eq2.add("air");	
		eq2.add("answer");	
		
		assertEquals("{apple | answer, air}", eq2.toString());
		assertEquals("apple", eq2.canonical());
		
		eq2.demoteAndSetCanonical("cat");
		assertEquals("{apple | answer, air}", eq2.toString());
		assertEquals("apple", eq2.canonical());
		
		eq2.demoteAndSetCanonical("animal");
		assertEquals("{animal | apple, answer, air}", eq2.toString());
		assertEquals("animal", eq2.canonical());
		
		eq2.clearNonCanonical();
		assertFalse(eq2.isEmpty());
		
		eq2.removeCanonical();
		assertTrue(eq2.isEmpty());
		
		eq2.add("boo");	
		assertFalse(eq2.isEmpty());
		eq2.clear();
		assertTrue(eq2.isEmpty());
	}

	@Test
	void clearTest() 
	{
		Comparator<Integer> c1 = new Comparator<Integer>()  
		{
			// All even integers are 'equivalent' 
			public int compare(Integer x, Integer y) { return x % 2 == y % 2 ? 0 : 1; } 
		};
		
		LinkedEquivalenceClass<Integer> eq1 = new LinkedEquivalenceClass<Integer>(c1);
			
		eq1.add(1);
		eq1.add(2);	
		eq1.add(3);	

		assertFalse(eq1.isEmpty());
		eq1.clear();
		assertTrue(eq1.isEmpty());
		
		Comparator<String> c2 = new Comparator<String>()
		{
			// All Strings with same first character are 'equivalent'
			public int compare(String x, String y) 
			{ 
				if(x.length() == 0 || y.length() == 0) return 1;
				
				return x.charAt(0) == y.charAt(0) ? 0 : 1; 
			}
		};
		
		LinkedEquivalenceClass<String> eq2 = new LinkedEquivalenceClass<String>(c2);
																				
		eq2.add("apple");	
		eq2.add("bin");	
		eq2.add("air");	
	
		assertFalse(eq2.isEmpty());
		eq2.clear();
		eq2.clear();
		assertTrue(eq2.isEmpty());
		
	}
	
	@Test
	void clearNonCanonicalTest() 
	{
		Comparator<Integer> c1 = new Comparator<Integer>()  
		{
			// All even integers are 'equivalent' 
			public int compare(Integer x, Integer y) { return x % 2 == y % 2 ? 0 : 1; } 
		};
		
		LinkedEquivalenceClass<Integer> eq1 = new LinkedEquivalenceClass<Integer>(c1);
			
		eq1.add(1);
		eq1.add(2);	
		eq1.add(3);	
		eq1.clearNonCanonical();
		assertEquals("{1 | }", eq1.toString());
		
		Comparator<String> c2 = new Comparator<String>()
		{
			// All Strings with same first character are 'equivalent'
			public int compare(String x, String y) 
			{ 
				if(x.length() == 0 || y.length() == 0) return 1;
				
				return x.charAt(0) == y.charAt(0) ? 0 : 1; 
			}
		};
		
		LinkedEquivalenceClass<String> eq2 = new LinkedEquivalenceClass<String>(c2);
				
		eq2.add("apple");	
		eq2.add("bin");	
		eq2.add("air");	
		eq2.clearNonCanonical();
		eq2.clearNonCanonical();
		assertEquals("{apple | }", eq2.toString());
	}

	@Test
	void sizeTest() 
	{
		Comparator<Integer> c1 = new Comparator<Integer>()  
		{
			// All even integers are 'equivalent' 
			public int compare(Integer x, Integer y) { return x % 2 == y % 2 ? 0 : 1; } 
		};
		
		LinkedEquivalenceClass<Integer> eq1 = new LinkedEquivalenceClass<Integer>(c1);
			
		assertEquals(0, eq1.size());
		eq1.add(1);
		eq1.add(2);	
		eq1.add(3);
		eq1.add(5);	
		assertEquals(3, eq1.size());
		
		eq1.demoteAndSetCanonical(7);
		assertEquals(4, eq1.size());
		
		eq1.removeCanonical();
		assertEquals(3, eq1.size());
		
		eq1.removeCanonical();
		assertEquals(2, eq1.size());
		
		eq1.clearNonCanonical();
		assertEquals(1, eq1.size());
		
		eq1.add(9);
		assertEquals(2, eq1.size());
		
		eq1.clear();
		assertEquals(0, eq1.size());
		
		
		
		
		Comparator<String> c2 = new Comparator<String>()
		{
			// All Strings with same first character are 'equivalent'
			public int compare(String x, String y) 
			{ 
				if(x.length() == 0 || y.length() == 0) return 1;
				
				return x.charAt(0) == y.charAt(0) ? 0 : 1; 
			}
		};
		
		LinkedEquivalenceClass<String> eq2 = new LinkedEquivalenceClass<String>(c2);
																				
		assertEquals(0, eq2.size());
		eq2.add("an");
		eq2.add("wow");	
		eq2.add("arrow");
		eq2.add("app");	
		assertEquals(3, eq2.size());
		
		eq2.demoteAndSetCanonical("ant");
		assertEquals(4, eq2.size());
		
		eq2.removeCanonical();
		assertEquals(3, eq2.size());
		
		eq2.removeCanonical();
		assertEquals(2, eq2.size());
		
		eq2.clearNonCanonical();
		assertEquals(1, eq2.size());
		
		eq2.add("along");
		assertEquals(2, eq2.size());
		
		eq2.clear();
		assertEquals(0, eq2.size());
	}

	@Test
	void addTest() 
	{
		Comparator<Integer> c1 = new Comparator<Integer>()  
		{
			// All even integers are 'equivalent' 
			public int compare(Integer x, Integer y) { return x % 2 == y % 2 ? 0 : 1; } 
		};
		
		LinkedEquivalenceClass<Integer> eq1 = new LinkedEquivalenceClass<Integer>(c1);
			
		eq1.add(1);
		eq1.add(2);	
		eq1.add(3);	
		assertEquals("{1 | 3}", eq1.toString());
		assertEquals(1, eq1.canonical());
		
		eq1.demoteAndSetCanonical(5);
		assertEquals("{5 | 1, 3}", eq1.toString());
		assertEquals(5, eq1.canonical());
		
		
		
		Comparator<String> c2 = new Comparator<String>()
		{
			// All Strings with same first character are 'equivalent'
			public int compare(String x, String y) 
			{ 
				if(x.length() == 0 || y.length() == 0) return 1;
				
				return x.charAt(0) == y.charAt(0) ? 0 : 1; 
			}
		};
		
		LinkedEquivalenceClass<String> eq2 = new LinkedEquivalenceClass<String>(c2);
																				
		eq2.add("apple");	
		eq2.add("bin");	
		eq2.add("air");	
		eq2.add("answer");	
		
		assertEquals("{apple | answer, air}", eq2.toString());
		assertEquals("apple", eq2.canonical());
		
		eq2.demoteAndSetCanonical("cat");
		assertEquals("{apple | answer, air}", eq2.toString());
		assertEquals("apple", eq2.canonical());
		
		eq2.demoteAndSetCanonical("animal");
		assertEquals("{animal | apple, answer, air}", eq2.toString());
		assertEquals("animal", eq2.canonical());
	}

	@Test
	void containsTest() 
	{
		Comparator<Integer> c1 = new Comparator<Integer>()  
		{
			// All even integers are 'equivalent' 
			public int compare(Integer x, Integer y) { return x % 2 == y % 2 ? 0 : 1; } 
		};
		
		LinkedEquivalenceClass<Integer> eq1 = new LinkedEquivalenceClass<Integer>(c1);
			
		eq1.add(1);
		eq1.add(2);	
		eq1.add(3);
		assertTrue(eq1.contains(1));
		assertFalse(eq1.contains(2));
		assertTrue(eq1.contains(3));
		
		eq1.demoteAndSetCanonical(5);
		assertTrue(eq1.contains(1));
		assertTrue(eq1.contains(5));
		
		eq1.clearNonCanonical();
		assertTrue(eq1.contains(5));
		assertFalse(eq1.contains(1));
		assertFalse(eq1.contains(3));
		
		eq1.clear();
		assertFalse(eq1.contains(5));
		
		
		Comparator<String> c2 = new Comparator<String>()
		{
			// All Strings with same first character are 'equivalent'
			public int compare(String x, String y) 
			{ 
				if(x.length() == 0 || y.length() == 0) return 1;
				
				return x.charAt(0) == y.charAt(0) ? 0 : 1; 
			}
		};
		
		LinkedEquivalenceClass<String> eq2 = new LinkedEquivalenceClass<String>(c2);
																				
		eq2.add("apple");	
		eq2.add("bin");	
		eq2.add("air");	
		
		assertTrue(eq2.contains("apple"));
		assertFalse(eq2.contains("bin"));
		assertTrue(eq2.contains("air"));
		
		eq2.demoteAndSetCanonical("allow");
		assertTrue(eq2.contains("allow"));
		assertTrue(eq2.contains("apple"));
		
		eq2.clearNonCanonical();
		assertTrue(eq2.contains("allow"));
		assertFalse(eq2.contains("apple"));
		assertFalse(eq2.contains("air"));
		
		eq2.clear();
		assertFalse(eq2.contains("allow"));
	}

	@Test
	void belongsTest() 
	{
		Comparator<Integer> c1 = new Comparator<Integer>()  
		{
			// All even integers are 'equivalent' 
			public int compare(Integer x, Integer y) { return x % 2 == y % 2 ? 0 : 1; } 
		};
		
		LinkedEquivalenceClass<Integer> eq1 = new LinkedEquivalenceClass<Integer>(c1);
			
		eq1.add(1);
		eq1.add(2);	
		eq1.add(3);	
		
		assertFalse(eq1.belongs(2));
		assertFalse(eq1.belongs(4));
		assertFalse(eq1.belongs(24));
		
		assertTrue(eq1.belongs(11));
		assertTrue(eq1.belongs(1));
		
		eq1.clear();
		eq1.add(2);
		assertFalse(eq1.belongs(11));
		assertTrue(eq1.belongs(24));

		
		Comparator<String> c2 = new Comparator<String>()
		{
			// All Strings with same first character are 'equivalent'
			public int compare(String x, String y) 
			{ 
				if(x.length() == 0 || y.length() == 0) return 1;
				
				return x.charAt(0) == y.charAt(0) ? 0 : 1; 
			}
		};
		
		LinkedEquivalenceClass<String> eq2 = new LinkedEquivalenceClass<String>(c2);
																				
		eq2.add("apple");	
		eq2.add("bin");	
		eq2.add("air");	
		eq2.add("answer");	
		
		assertFalse(eq2.belongs("bee"));
		assertFalse(eq2.belongs("danger"));

		
		assertTrue(eq2.belongs("a"));
		assertTrue(eq2.belongs("anger"));
		
		eq2.clear();
		eq2.add("boo");
		assertFalse(eq2.belongs("allow"));
		assertTrue(eq2.belongs("bare"));
	}

	@Test
	void removeTest() 
	{
		Comparator<Integer> c1 = new Comparator<Integer>()  
		{
			// All even integers are 'equivalent' 
			public int compare(Integer x, Integer y) { return x % 2 == y % 2 ? 0 : 1; } 
		};
		
		LinkedEquivalenceClass<Integer> eq1 = new LinkedEquivalenceClass<Integer>(c1);
			
		eq1.add(1);
		eq1.add(2);	
		eq1.add(3);	
		
		assertFalse(eq1.remove(2));
		
		eq1.remove(1);
		assertEquals("{3 | }", eq1.toString());
		eq1.remove(3);
		assertTrue(eq1.isEmpty());
		
		
		
	
		Comparator<String> c2 = new Comparator<String>()
		{
			// All Strings with same first character are 'equivalent'
			public int compare(String x, String y) 
			{ 
				if(x.length() == 0 || y.length() == 0) return 1;
				
				return x.charAt(0) == y.charAt(0) ? 0 : 1; 
			}
		};
		
		LinkedEquivalenceClass<String> eq2 = new LinkedEquivalenceClass<String>(c2);
																				
		eq2.add("apple");	
		eq2.add("bin");	
		eq2.add("air");	
		eq2.add("answer");	
		
		assertFalse(eq2.remove("bin"));
		
		eq2.remove("apple");
		assertEquals("{answer | air}", eq2.toString());
		eq2.remove("air");
		eq2.remove("answer");
		assertTrue(eq2.isEmpty());
		
	}
	
	@Test
	void removeCanonicalTest() 
	{
		Comparator<Integer> c1 = new Comparator<Integer>()  
		{
			// All even integers are 'equivalent' 
			public int compare(Integer x, Integer y) { return x % 2 == y % 2 ? 0 : 1; } 
		};
		
		LinkedEquivalenceClass<Integer> eq1 = new LinkedEquivalenceClass<Integer>(c1);
			

		eq1.add(1);
		eq1.add(2);	
		eq1.add(3);
		eq1.add(5);	
		assertEquals("{1 | 5, 3}", eq1.toString());
		
		eq1.removeCanonical();
		assertEquals("{5 | 3}", eq1.toString());
		
		eq1.removeCanonical();
		assertEquals("{3 | }", eq1.toString());
		
		eq1.removeCanonical();
		assertTrue(eq1.isEmpty());
		
		
		Comparator<String> c2 = new Comparator<String>()
		{
			// All Strings with same first character are 'equivalent'
			public int compare(String x, String y) 
			{ 
				if(x.length() == 0 || y.length() == 0) return 1;
				
				return x.charAt(0) == y.charAt(0) ? 0 : 1; 
			}
		};
		
		LinkedEquivalenceClass<String> eq2 = new LinkedEquivalenceClass<String>(c2);
																				
		assertEquals(0, eq2.size());
		eq2.add("an");
		eq2.add("wow");	
		eq2.add("arrow");
		eq2.add("app");	
		
		assertEquals("{an | app, arrow}", eq2.toString());
		
		eq2.removeCanonical();
		assertEquals("{app | arrow}", eq2.toString());
		
		eq2.removeCanonical();
		assertEquals("{arrow | }", eq2.toString());
		
		eq2.removeCanonical();
		assertTrue(eq2.isEmpty());
	}

	@Test
	void demoteAndSetCanonicalTest() 
	{
		Comparator<Integer> c1 = new Comparator<Integer>()  
		{
			// All even integers are 'equivalent' 
			public int compare(Integer x, Integer y) { return x % 2 == y % 2 ? 0 : 1; } 
		};
		
		LinkedEquivalenceClass<Integer> eq1 = new LinkedEquivalenceClass<Integer>(c1);
			
		eq1.add(1);
		eq1.add(2);	
		eq1.add(3);	
		assertEquals("{1 | 3}", eq1.toString());
		assertEquals(1, eq1.canonical());
		
		eq1.demoteAndSetCanonical(5);
		assertEquals("{5 | 1, 3}", eq1.toString());
		assertEquals(5, eq1.canonical());
		
		assertFalse(eq1.demoteAndSetCanonical(4));

		
		Comparator<String> c2 = new Comparator<String>()
		{
			// All Strings with same first character are 'equivalent'
			public int compare(String x, String y) 
			{ 
				if(x.length() == 0 || y.length() == 0) return 1;
				
				return x.charAt(0) == y.charAt(0) ? 0 : 1; 
			}
		};
		
		LinkedEquivalenceClass<String> eq2 = new LinkedEquivalenceClass<String>(c2);
																				
		eq2.add("apple");	
		eq2.add("bin");	
		eq2.add("air");	
		eq2.add("answer");	
		
		assertEquals("{apple | answer, air}", eq2.toString());
		assertEquals("apple", eq2.canonical());
		
		eq2.demoteAndSetCanonical("cat");
		assertEquals("{apple | answer, air}", eq2.toString());
		assertEquals("apple", eq2.canonical());
		
		eq2.demoteAndSetCanonical("animal");
		assertEquals("{animal | apple, answer, air}", eq2.toString());
		assertEquals("animal", eq2.canonical());
		
		assertFalse(eq2.demoteAndSetCanonical("roar"));
	}
	
	@Test
	void toStringTest() 
	{
		Comparator<Integer> c1 = new Comparator<Integer>()  
		{
			// All even integers are 'equivalent' 
			public int compare(Integer x, Integer y) { return x % 2 == y % 2 ? 0 : 1; } 
		};
		
		LinkedEquivalenceClass<Integer> eq1 = new LinkedEquivalenceClass<Integer>(c1);
			
		eq1.add(1);
		eq1.add(2);	
		eq1.add(3);	
		assertEquals("{1 | 3}", eq1.toString());
		assertEquals(1, eq1.canonical());
		
		eq1.demoteAndSetCanonical(5);
		assertEquals("{5 | 1, 3}", eq1.toString());
		assertEquals(5, eq1.canonical());
		
		
		
		Comparator<String> c2 = new Comparator<String>()
		{
			// All Strings with same first character are 'equivalent'
			public int compare(String x, String y) 
			{ 
				if(x.length() == 0 || y.length() == 0) return 1;
				
				return x.charAt(0) == y.charAt(0) ? 0 : 1; 
			}
		};
		
		LinkedEquivalenceClass<String> eq2 = new LinkedEquivalenceClass<String>(c2);
																				
		eq2.add("apple");	
		eq2.add("bin");	
		eq2.add("air");	
		eq2.add("answer");	
		
		assertEquals("{apple | answer, air}", eq2.toString());
		assertEquals("apple", eq2.canonical());
		
		eq2.demoteAndSetCanonical("cat");
		assertEquals("{apple | answer, air}", eq2.toString());
		assertEquals("apple", eq2.canonical());
		
		eq2.demoteAndSetCanonical("animal");
		assertEquals("{animal | apple, answer, air}", eq2.toString());
		assertEquals("animal", eq2.canonical());
	}


}
