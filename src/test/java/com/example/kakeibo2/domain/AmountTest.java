package com.example.kakeibo2.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.example.kakeibo2.domain.exception.InvalidAmountException;
import com.example.kakeibo2.domain.valueobject.Amount;

public class AmountTest {
	@Test
	void 正常_１以上の値で作成できる() {
		int input = 1;
		Amount amount = new Amount(input);
		assertEquals(input, amount.getValue());
		
	}
	
	@Test
	void 異常_0で作成すると例外() {
		int input = 0;
		assertThrows(InvalidAmountException.class, () -> new Amount(input));
	}
	
	@Test
	void 異常_負の値で作成すると例外() {
		int input = -1;
		assertThrows(InvalidAmountException.class, () -> new Amount(input));
	}


}
