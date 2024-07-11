package com.example.retrofit_app.screens
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit_app.model.Personaje
import com.example.retrofit_app.repository.PersonajesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel

class PersonajesViewModel @Inject constructor(
    private val repo : PersonajesRepository
): ViewModel(){
    private val _state = MutableStateFlow(emptyList< Personaje>())
    val state : StateFlow<List<Personaje>>
        get() = _state

    init {
viewModelScope.launch{
    _state.value = repo.getPersonajes().results
}
    }
}