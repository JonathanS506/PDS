<template>
  <v-container class="fill-height" fluid>
    <v-row align="center" justify="center">
      <v-col cols="12">
        <ConsularSaldoActualDolaresFormulario @cuentaCreada="handleCuentaCreada" />
      </v-col>
    </v-row>
  </v-container>
</template>

<script setup>
//import { ref } from 'vue'
import ConsularSaldoActualDolaresFormulario from '@/components/ConsularSaldoActualDolaresFormulario.vue'
</script>

<style scoped>
.fill-height {
  min-height: 100vh;
}

.v-card {
  max-width: 600px;
  margin: 0 auto;
}
</style>
