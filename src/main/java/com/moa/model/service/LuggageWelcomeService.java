package com.moa.model.service;

import java.util.Map;

public interface LuggageWelcomeService {
    Map<String, Object> initBoard(String hostId);
    int noticeStorage(Map<String, Object> articleMap);
}
