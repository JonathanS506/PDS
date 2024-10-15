<template>
  <v-container fluid>
    <v-row justify="center">
      <v-col cols="12" md="10">
        <v-card class="elevation-12">
          <v-card-title class="title text-center"> Cambiar Número de Teléfono </v-card-title>
          <v-card-text>
            <v-form ref="formCambiarTelefono" v-model="valid" lazy-validation>
              <v-row>
                <v-col cols="12" md="6">
                  <v-text-field
                    label="ID del Cliente"
                    v-model="clienteSeleccionado"
                    :rules="[rules.required]"
                    required
                  />
                </v-col>
                <v-col cols="12" md="6">
                  <v-btn color="blue darken-1" @click="buscarCliente">Buscar Cliente</v-btn>
                </v-col>
              </v-row>

              <v-row v-if="clienteEncontrado">
                <v-col cols="12">
                  <v-card>
                    <v-card-title>Datos del Cliente</v-card-title>
                    <v-card-text>
                      <p>
                        <strong>Número de Teléfono Actual:</strong>
                        {{ telefonoActual }}
                      </p>
                    </v-card-text>
                  </v-card>
                </v-col>
              </v-row>

              <v-row v-if="clienteEncontrado">
                <v-col cols="12" md="6">
                  <v-text-field
                    label="Nuevo Número de Teléfono"
                    v-model="nuevoTelefono"
                    :rules="[rules.required, rules.validarTelefono]"
                    required
                  />
                </v-col>
              </v-row>

              <v-row v-if="clienteEncontrado">
                <v-col cols="12" class="text-center">
                  <v-btn color="green darken-1" @click="submitForm">Cambiar Teléfono</v-btn>
                </v-col>
              </v-row>

              <!-- Botones para atrás y salir -->
              <v-row justify="center">
                <v-col cols="4" class="pa-2">
                  <BotonAtras />
                </v-col>
                <v-col cols="4" class="pa-2">
                  <BotonSalir />
                </v-col>
              </v-row>

              <v-row v-if="mensajeConfirmacion">
                <v-col cols="12" class="pa-2">
                  <v-alert type="success">
                    {{ mensajeConfirmacion }}
                  </v-alert>
                </v-col>
              </v-row>
              <v-row v-if="mensajeError">
                <v-col cols="12" class="pa-2">
                  <v-alert type="error">
                    {{ mensajeError }}
                  </v-alert>
                </v-col>
              </v-row>
            </v-form>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script setup>
import { ref } from 'vue'
import axios from 'axios'

// Importa los botones
import BotonAtras from '@/components/Botones/BotonAtras.vue'
import BotonSalir from '@/components/Botones/BotonSalir.vue'

const valid = ref(false)
const clienteSeleccionado = ref('') // El ID del cliente introducido manualmente
const clienteEncontrado = ref(false) // Indica si el cliente existe
const telefonoActual = ref('') // El número de teléfono actual del cliente
const nuevoTelefono = ref('') // El nuevo número a ingresar
const mensajeConfirmacion = ref('')
const mensajeError = ref('')

const rules = {
  required: (value) => !!value || 'Campo requerido',
  validarTelefono: (value) => {
    const telefonoRegex = /^\d{8}$/ // Valida que tenga exactamente 8 dígitos
    return telefonoRegex.test(value) || 'El número de teléfono debe tener 8 dígitos'
  }
}

// Función para buscar el cliente por su ID
const buscarCliente = async () => {
  try {
    const response = await axios.get(
      `http://localhost:8080/api/clientes/${clienteSeleccionado.value}`
    )
    const cliente = response.data
    clienteEncontrado.value = true
    telefonoActual.value = cliente.telefono // Asigna el número actual
    mensajeError.value = '' // Resetea el mensaje de error
  } catch (error) {
    clienteEncontrado.value = false
    mensajeError.value = 'Cliente no encontrado'
  }
}

// Función para enviar el formulario y actualizar el teléfono
const submitForm = async () => {
  if (valid.value) {
    if (nuevoTelefono.value === telefonoActual.value) {
      mensajeError.value = 'El nuevo número de teléfono no puede ser el mismo que el actual.'
      return
    }

    try {
      await axios.put(`http://localhost:8080/api/clientes/telefono/${clienteSeleccionado.value}`, {
        telefono: nuevoTelefono.value
      })
      mensajeConfirmacion.value = 'Número de teléfono actualizado exitosamente.'
      mensajeError.value = '' // Limpiar el mensaje de error
    } catch (error) {
      console.error('Error al cambiar el teléfono:', error.response?.data || error)
      mensajeError.value = 'Error al cambiar el número de teléfono. Inténtalo de nuevo.'
    }
  }
}
</script>

<style scoped>
.v-container {
  background: linear-gradient(to bottom right, #b9ece8, #43e4a1);
  height: 100vh;
}

.v-card {
  margin: 20px;
  background-color: #f9f9f9;
  border-radius: 12px;
}

.title {
  font-size: 2.5rem;
  font-weight: bold;
  color: #2c3e50;
  text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.2);
}
</style>
