package com.jetbrains.kmm.shared.shared_presentation.viewModel

sealed class UIEvent{
    data class ShowSnackbar(val message: String): UIEvent()
}
