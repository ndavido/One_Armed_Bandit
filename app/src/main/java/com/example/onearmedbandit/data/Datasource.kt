package com.example.onearmedbandit.data

import com.example.onearmedbandit.R
import com.example.onearmedbandit.model.Rules

class Datasource {

    fun loadRules(): List<Rules> {
        return listOf<Rules>(
            Rules(R.string.divider),
            Rules(R.string.rulesTitle),
            Rules(R.string.divider),
            Rules(R.string.rules1),
            Rules(R.string.divider),
            Rules(R.string.rules2),
            Rules(R.string.divider),
            Rules(R.string.rules3),
            Rules(R.string.rules4),
            Rules(R.string.rules5),
            Rules(R.string.rules6),
            Rules(R.string.divider),
            Rules(R.string.rules7),
            Rules(R.string.rules8),
            Rules(R.string.rules9),
            Rules(R.string.rules10),
            Rules(R.string.rules11),
            Rules(R.string.divider),
            Rules(R.string.rules12)
        )
    }
}