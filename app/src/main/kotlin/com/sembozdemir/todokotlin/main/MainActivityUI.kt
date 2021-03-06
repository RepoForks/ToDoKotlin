package com.sembozdemir.todokotlin.main

import android.support.v7.widget.LinearLayoutManager
import com.sembozdemir.todokotlin.extensions.asString
import com.sembozdemir.todokotlin.extensions.clear
import com.sembozdemir.todokotlin.extensions.defaultDivider
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivityUI(val todoListAdapter: TodoListAdapter) : AnkoComponent<MainActivity> {

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        verticalLayout {
            recyclerView {
                val orientation = LinearLayoutManager.VERTICAL
                layoutManager = LinearLayoutManager(ctx, orientation, false)
                defaultDivider()
                adapter = todoListAdapter
            }.lparams(width = matchParent,
                    height = dip(0),
                    weight = 1f)

            val editText = editText {
                hint = "Add note..."
            }

            button {
                text = "Add"
                onClick {
                    val note = editText.asString()
                    todoListAdapter.add(note)
                    editText.clear()
                }
            }
        }
    }
}