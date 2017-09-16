package com.qm.backend.util;



import com.qm.backend.constant.StringConstant;
import com.qm.backend.constant.SymbolConstant;

import java.util.UUID;

public class IDGeneratorUtil
{
    public static final String generator()
    {
        return UUID.randomUUID().toString().replaceAll(SymbolConstant.SUBTRACT, StringConstant.EMPTY);
    }
}
