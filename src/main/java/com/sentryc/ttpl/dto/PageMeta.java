package com.sentryc.ttpl.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PageMeta {

    private int page;

    private int size;

    private int totalRecords;
}
