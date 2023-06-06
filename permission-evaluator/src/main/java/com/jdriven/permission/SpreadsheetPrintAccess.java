package com.jdriven.permission;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("hasPermission(#spreadsheet, 'PRINT')")
public @interface SpreadsheetPrintAccess {
	// TODO Add security annotations
}
