package com.example.kakeibo2.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.example.kakeibo2.domain.exception.InvalidCategoryNameException;
import com.example.kakeibo2.domain.valueobject.CategoryName;

public class CategoryNameTest {
	@Test
	void 正常_入力値が食費() {
		String input = "食費";
		CategoryName name = new CategoryName(input);
		assertEquals(input, name.getValue());
		
	}
	
	
	@Test
	void 境界地_正常値_1文字で作成すると例外() {
		String input = "a";
		CategoryName name = new CategoryName(input);
		assertEquals(input, name.getValue());
	}
	@Test
	void 境界地_正常値_50文字で作成すると例外() {
		String input = "a";
		String inputs = input.repeat(50);
		CategoryName name = new CategoryName(inputs);
		assertEquals(inputs, name.getValue());
	}
	@Test
	void 境界地_異常値_51文字で作成すると例外() {
		String input = "a";
		String inputs = input.repeat(51);
		assertThrows(InvalidCategoryNameException.class, 
				() -> new CategoryName(inputs));
	}
	
	@Test
	void 境界地_異常値_0文字で作成すると例外() {
		String input = "";
		assertThrows(InvalidCategoryNameException.class,
				() -> new CategoryName(input));
	}
	
	@Test
	void 境界地_異常値_null文字で作成すると例外() {
		String input = null;
		assertThrows(InvalidCategoryNameException.class,
				() -> new CategoryName(input));
	}
	
	@Test
	void 境界地_異常値_空文字で作成すると例外() {
		String input = " ";
		assertThrows(InvalidCategoryNameException.class,
				() -> new CategoryName(input));
	}
	
	@Test
	void 境界地_異常値_空大文字で作成すると例外() {
		String input = "　";
		assertThrows(InvalidCategoryNameException.class,
				() -> new CategoryName(input));
	}
}
