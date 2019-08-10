package com.moa.message;

public class TransactionStateMessaage {
	public static final String WAITING_APPROVE = "승인대기중";
	public static final String BEFORE_PAYMENT = "결제전";
	public static final String COMPLETE_PAYMENT ="결제완료";
	public static final String STORE = "보관중";
	public static final String EXPIRED_STORE = "보관만료";
	public static final String COMPLETE_TRANSACTION = "거래완료";
	public static final String REJECT_APPROVE = "승인거절";
}
