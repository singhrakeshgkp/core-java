package com.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {

	public static void allMatch() {
		// List<String> techList = List.of("java","spring"," redis"," kafka");// false
		List<String> techList = List.of("java", " java spring", " java redis", " javakafka");// ture
		boolean isTrue = techList.stream().allMatch(str -> str.contains("java"));
		System.out.println(isTrue);
	}

	public static void anyMatch() {
		// List<String> techList = List.of("dfd","spring"," redis"," kafka");// false
		List<String> techList = List.of("science", " java spring", "fdf", " dsfds");// ture
		boolean isTrue = techList.stream().anyMatch(str -> str.contains("java"));
		System.out.println(isTrue);
	}

	public static void close() {
		List<String> techList = List.of("science", " java spring", "fdf", " dsfds");
		Stream<String> strStream = techList.stream();
		strStream.close();
		long counter = strStream.count();
		System.out.println(counter);
	}

	public static void collect() {
		List<String> techList = List.of("science", "java spring", "fdf", "dsfds");
		List<String> modifiedList = techList.stream().map(str -> str.concat(" tech")).collect(Collectors.toList());
		modifiedList.forEach(str -> System.out.println(str));
	}

	// Need t explore more
	public static void collectWithMultipleArgument() {
		List<String> techList = List.of("science", " java spring", "fdf", " dsfds");
		Stream<String> strStream = techList.stream();
		strStream.collect(null, null, null);

	}

	public static void count() {
		List<String> techList = List.of("science", " java spring", "fdf", " dsfds");
		Stream<String> strStream = techList.stream();
		long counter = strStream.filter(str -> str.contains("java")).count();
		System.out.println(counter);
	}

	public static void distinct() {
		List<String> techList = List.of("java", "java", "fdf", "java");
		List<String> distinctTechList = techList.stream().distinct().collect(Collectors.toList());
		distinctTechList.forEach(tech -> System.out.println(tech));
	}

	// dropWhile removes the elements that do match the predicate (in this case: n
	// -> n < 0), until it finds an element that does not match the predicate. From
	// that point on it lets all elements pass through
	public static void dropWhile() {
		List<String> techList = List.of("javaa", "rakesh", "javab", "fdf", "javac", "javae");
		List<String> filteredTechList = techList.stream().dropWhile(tech -> tech.contains("java"))
				.collect(Collectors.toList());
		filteredTechList.forEach(tech -> System.out.println(tech));
	}

	public static void filter() {
		List<String> techList = List.of("javaa", "rakesh", "javab", "fdf", "javac", "javae");
		List<String> javaTech = techList.stream().filter(tech -> tech.startsWith("java")).collect(Collectors.toList());
		javaTech.forEach(tech -> System.out.println(tech));

	}

	public static void findAny() {
		List<String> techList = List.of("javaa", "rakesh", "javab", "fdf", "javac", "javae");
		Optional<String> findAny = techList.stream().filter(str -> str.contains("java")).findAny();
		if (findAny.isPresent()) {
			System.out.println(findAny.get());
		} else {
			System.out.println("value not present");
		}

	}

	public static void findFirst() {
		List<String> techList = List.of("javaa", "rakesh", "javab", "fdf", "javac", "javae");
		Optional<String> findFirst = techList.stream().filter(str -> str.contains("rakesh")).findFirst();
		if (findFirst.isPresent()) {
			System.out.println(findFirst.get());
		} else {
			System.out.println("value not present");
		}

	}

	// for more details refer article
	// https://mkyong.com/java8/java-8-flatmap-example/
	public static void flatMap() {
		String[][] nameArr = { { "java", "spring" }, { ".net", "asp.net" }, { "orm", "messaging service" } };
		List<String> flatResult = Arrays.stream(nameArr).flatMap(Stream::of).filter(s -> s.contains(".net"))
				.collect(Collectors.toList());
		flatResult.forEach(System.out::println);
	}

	/*
	 * foreach->If used with parallel stream, this operation doesn't guarantee to
	 * maintain order of the stream foreachordered-> it maintain the order if use
	 * with parallel stream
	 */
	public static void foreachOrdered() {
		String str = "rakesh Singh";
		System.out.println("with foreach");
		str.chars().parallel().forEach(s -> System.out.print((char) s));
		System.out.println("");
		System.out.println("with foreachOrdered");
		str.chars().parallel().forEachOrdered(s -> System.out.print((char) s));

	}

	public static void limit() {
		List<String> techList = List.of("javaa", "rakesh", "javab", "fdf", "javac", "javae");
		List<String> limitedTechList = techList.stream().limit(5).filter(s -> s.contains("java"))
				.collect(Collectors.toList());
		limitedTechList.forEach(System.out::println);
	}

	// Map the string type list to integer type list
	public static void map() {
		List<String> strList = List.of("55", "60", "80", "90", "78", "44");
		List<Integer> intList = strList.stream().map(Integer::valueOf).collect(Collectors.toList());
		intList.forEach(System.out::println);
	}
	// return true if stream is empty or no element match the predicate
	public static void nonMatch() {
		List<String> strList = List.of("55", "60", "80", "90", "78", "44");
		boolean nonMatched = strList.stream().noneMatch(str-> str.equalsIgnoreCase("999"));
		System.out.println("value are "+nonMatched);
	}
	
	public static void nonMatchfdf() {
		List<String> strList = List.of("55", "60", "80", "90", "78", "44");
	// strList.stream().;
	}
	public static void main(String[] args) {
		// allMatch();
		// anyMatch();
		// close();
		// distinct();
		// dropWhile();
		// filter();
		// findAny();
		// findFirst();
		// flatMap();
		// foreachOrdered();
		// limit();
         //  map();
		nonMatch();
	}
}
