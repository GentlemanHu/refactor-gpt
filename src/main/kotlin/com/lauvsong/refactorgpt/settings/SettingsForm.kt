package com.lauvsong.refactorgpt.settings

import com.intellij.ui.JBIntSpinner
import com.intellij.ui.components.JBTextField
import com.intellij.util.ui.FormBuilder
import java.awt.BorderLayout
import javax.swing.JPanel

class SettingsForm {
    private val apiKeyField = JBTextField()
    private val apiUrlField = JBTextField()
    private val responseTimeoutSpinner = JBIntSpinner(10, 1, 300)
    var isModified = false

    private val formPanel: JPanel = FormBuilder.createFormBuilder()
        .addLabeledComponent("ChatGPT API key:", apiKeyField)
        .addLabeledComponent("OpenAI API Entry:",apiUrlField)
        .addLabeledComponent("Response timeout (1~300):", responseTimeoutSpinner)
        .panel

    val panel = JPanel(BorderLayout())

    init {
        panel.add(formPanel, BorderLayout.NORTH)
        responseTimeoutSpinner.addChangeListener {
            isModified = true
        }
    }

    var apiKey: String
        get() = apiKeyField.text
        set(value) {
            apiKeyField.text = value
        }

    var apiUrl:String
        get() = apiUrlField.text
        set(value) {
            apiUrlField.text = value
        }

    var responseTimeout: Int
        get() = responseTimeoutSpinner.value as Int
        set(value) {
            responseTimeoutSpinner.value = value
        }

    fun apply() {
        isModified = false
    }
}
