<template>
  <v-container fluid>
    <v-row justify="center">
      <v-col cols="12" md="10">
        <v-card class="elevation-12">
          <v-card-title class="title text-center"> Cambiar Correo Electrónico </v-card-title>
          <v-card-text>
            <v-form ref="formCambiarCorreo" v-model="valid" lazy-validation>
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
                        <strong>Correo Electrónico Actual:</strong>
                        {{ correoActual }}
                      </p>
                    </v-card-text>
                  </v-card>
                </v-col>
              </v-row>

              <v-row v-if="clienteEncontrado">
                <v-col cols="12" md="6">
                  <v-text-field
                    label="Nueva Dirección de Correo Electrónico"
                    v-model="nuevoCorreo"
                    :rules="[rules.required, rules.emailValido]"
                    required
                  />
                </v-col>
              </v-row>

              <v-row v-if="clienteEncontrado">
                <v-col cols="12" class="text-center">
                  <v-btn color="green darken-1" @click="submitForm">Cambiar Correo</v-btn>
                </v-col>
              </v-row>

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
import BotonAtras from '@/components/Botones/BotonAtras.vue'
import BotonSalir from '@/components/Botones/BotonSalir.vue'

const valid = ref(false)
const clienteSeleccionado = ref('') // El ID del cliente introducido manualmente
const clienteEncontrado = ref(false) // Indica si el cliente existe
const correoActual = ref('') // El correo actual del cliente
const nuevoCorreo = ref('') // El nuevo correo a ingresar
const mensajeConfirmacion = ref('')
const mensajeError = ref('')

const rules = {
  required: (value) => !!value || 'Campo requerido',
  emailValido: (value) => /.+@.+\..+/.test(value) || 'Correo electrónico no válido'
}

// Función para buscar el cliente por su ID
const buscarCliente = async () => {
  try {
    const response = await axios.get(
      `http://localhost:8080/api/clientes/${clienteSeleccionado.value}`
    )
    const cliente = response.data
    clienteEncontrado.value = true
    correoActual.value = cliente.correoElectronico // Asigna el correo actual
    mensajeError.value = '' // Resetea el mensaje de error
  } catch (error) {
    clienteEncontrado.value = false
    mensajeError.value = 'Cliente no encontrado'
  }
}

// Función para enviar el formulario y actualizar el correo
const submitForm = async () => {
  if (valid.value && clienteEncontrado.value) {
    try {
      await axios.put(`http://localhost:8080/api/clientes/correo/${clienteSeleccionado.value}`, {
        correoElectronico: nuevoCorreo.value
      })
      mensajeConfirmacion.value = 'Correo electrónico actualizado exitosamente.'
      mensajeError.value = '' // Limpiar el mensaje de error
    } catch (error) {
      console.error('Error al cambiar el correo:', error.response?.data || error)
      mensajeError.value = 'Error al cambiar el correo electrónico. Inténtalo de nuevo.'
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
