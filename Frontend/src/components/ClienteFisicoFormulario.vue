<template>
  <v-container fluid>
    <v-row justify="center">
      <v-col cols="12" md="10">
        <v-card class="elevation-12">
          <v-card-title class="title text-center"> Crear Cliente Físico </v-card-title>
          <v-card-text>
            <v-form ref="formClienteFisico" v-model="valid" lazy-validation>
              <v-row>
                <!-- Campos del formulario -->
                <v-col cols="12" md="6">
                  <v-text-field
                    label="Nombre del cliente"
                    v-model="clienteFisico.nombrePila"
                    :rules="[rules.required]"
                    required
                  />
                </v-col>
                <v-col cols="12" md="6">
                  <v-text-field
                    label="Primer Apellido"
                    v-model="clienteFisico.primerApellido"
                    :rules="[rules.required]"
                    required
                  />
                </v-col>
                <v-col cols="12" md="6">
                  <v-text-field
                    label="Segundo apellido"
                    v-model="clienteFisico.segundoApellido"
                    :rules="[rules.required]"
                  />
                </v-col>
                <v-col cols="12" md="6">
                  <v-text-field
                    label="Cédula de identidad"
                    v-model="clienteFisico.identificacion"
                    :rules="[rules.required, rules.validarIdentificacion]"
                    required
                  />
                </v-col>
                <v-col cols="12" md="6">
                  <v-text-field
                    label="Fecha de nacimiento"
                    v-model="clienteFisico.fechaNacimiento"
                    type="date"
                    :rules="[rules.required, rules.validarFechaNacimiento]"
                    required
                  />
                </v-col>
                <v-col cols="12" md="6">
                  <v-text-field
                    label="Número de teléfono"
                    v-model="clienteFisico.telefono"
                    :rules="[rules.required, rules.validarTelefono]"
                    required
                  />
                </v-col>
                <v-col cols="12" md="6">
                  <v-text-field
                    label="Correo electrónico"
                    v-model="clienteFisico.correoElectronico"
                    :rules="[rules.required, rules.validarCorreo]"
                    required
                  />
                </v-col>
                <v-col cols="12" md="6">
                  <v-text-field
                    label="Cantidad de cuentas"
                    v-model="clienteFisico.cantidadCuentas"
                    type="number"
                    :rules="[rules.required, rules.validarCantidadCuentas]"
                    required
                  />
                </v-col>
              </v-row>
              <v-row class="mt-4" justify="center">
                <v-col cols="4" class="text-center">
                  <BotonAtras />
                </v-col>
                <v-col cols="4" class="text-center">
                  <v-btn color="green darken-1" @click="handleRegistro">Registrar</v-btn>
                </v-col>
                <v-col cols="4" class="text-center">
                  <BotonSalir />
                </v-col>
              </v-row>
              <v-row justify="center">
                <v-col cols="12" class="text-center">
                  <v-alert v-if="mensaje" type="success" dismissible>{{ mensaje }}</v-alert>
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
import BotonAtras from '@/components/Botones/BotonAtras.vue'
import BotonSalir from '@/components/Botones/BotonSalir.vue'
import axios from 'axios'

const valid = ref(false)
const clienteFisico = ref({
  nombrePila: '',
  primerApellido: '',
  segundoApellido: '',
  identificacion: '',
  fechaNacimiento: '',
  telefono: '',
  correoElectronico: '',
  cantidadCuentas: 1
})
const mensaje = ref('')
const formClienteFisico = ref(null)
const rules = {
  required: (value) => !!value || 'Campo requerido',
  validarTelefono: (value) =>
    /^\d{8}$/.test(value) || 'El número de teléfono debe tener 8 dígitos.',
  validarCorreo: (value) =>
    /^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Z|a-z]{2,}$/.test(value) ||
    'Correo electrónico inválido.',
  validarCantidadCuentas: (value) =>
    (Number.isInteger(Number(value)) && value >= 1 && value <= 10) ||
    'La cantidad de cuentas debe ser un número entre 1 y 10.',
  validarIdentificacion: (value) =>
    /^\d{9}$/.test(value) || 'La cédula de identidad debe tener 9 dígitos.',
  validarFechaNacimiento: (value) => {
    const fechaNacimiento = new Date(value)
    const fechaHoy = new Date()
    return fechaNacimiento <= fechaHoy || 'La fecha de nacimiento no puede ser futura.'
  }
}

const handleRegistro = async () => {
  const formIsValid = await formClienteFisico.value.validate()
  if (formIsValid) {
    try {
      const response = await axios.post(
        'http://localhost:8080/api/clientes/fisico',
        clienteFisico.value
      )
      console.log(response.data)
      mensaje.value = 'Cliente registrado exitosamente.'
      Object.keys(clienteFisico.value).forEach((key) => {
        clienteFisico.value[key] = ''
      })
    } catch (error) {
      console.error('Error al registrar cliente físico:', error.response?.data || error)
      mensaje.value = 'Error al registrar el cliente. Inténtalo de nuevo.'
    }
  } else {
    mensaje.value = 'Por favor, complete todos los campos correctamente.'
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
  background-color: papayawhip;
  border-radius: 12px;
}
.title {
  font-size: 2.5rem;
  font-weight: bold;
  color: #2c3e50;
  text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.2);
}
.v-row {
  margin-bottom: 20px;
}
</style>
