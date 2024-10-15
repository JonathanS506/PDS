<template>
  <v-container fluid>
    <v-row justify="center">
      <v-col cols="12" md="10">
        <v-card class="elevation-12">
          <v-card-title class="title text-center">Realizar Transferencia</v-card-title>
          <v-card-text>
            <v-form ref="formTransferencia" v-model="valid" lazy-validation>
              <v-row>
                <!-- Cuenta Origen -->
                <v-col cols="12" md="6">
                  <v-text-field
                    label="Número de Cuenta Origen"
                    v-model="transferencia.cuentaOrigen"
                    :rules="[rules.required]"
                    required
                  />
                </v-col>

                <!-- PIN -->
                <v-col cols="12" md="6">
                  <v-text-field
                    label="PIN de la cuenta"
                    v-model="transferencia.pin"
                    :rules="[rules.required]"
                    required
                    type="password"
                  />
                </v-col>

                <!-- Monto -->
                <v-col cols="12" md="6">
                  <v-text-field
                    label="Monto de la transferencia"
                    v-model="transferencia.monto"
                    :rules="[rules.required, rules.isNumber]"
                    required
                  />
                </v-col>

                <!-- Cuenta Destino -->
                <v-col cols="12" md="6">
                  <v-text-field
                    label="Número de Cuenta Destino"
                    v-model="transferencia.cuentaDestino"
                    :rules="[rules.required]"
                    required
                  />
                </v-col>
              </v-row>

              <v-row class="mt-4" justify="center">
                <v-col cols="4" class="text-center">
                  <BotonAtras />
                </v-col>
                <v-col cols="4" class="text-center">
                  <v-btn color="green darken-1" @click="submitForm">Transferir</v-btn>
                </v-col>
                <v-col cols="4" class="text-center">
                  <BotonSalir />
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

const formTransferencia = ref(null)
const valid = ref(false)
const transferencia = ref({
  cuentaOrigen: '',
  pin: '',
  monto: '',
  cuentaDestino: ''
})

const rules = {
  required: (value) => !!value || 'Campo requerido',
  isNumber: (value) => !isNaN(value) || 'Debe ser un número'
}

const submitForm = () => {
  if (formTransferencia.value.validate()) {
    console.log('Transferencia realizada:', transferencia.value)
    // Aquí iría la lógica para enviar los datos al back-end
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
