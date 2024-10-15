<template>
  <v-container class="fill-height" fluid>
    <v-row align="center" justify="center">
      <v-col cols="12">
        <ConsultaSaldoActualColonesFormulario @cuentaCreada="handleCuentaCreada" />
      </v-col>
    </v-row>
  </v-container>
</template>

<script setup>
//import { ref } from 'vue'
import ConsultaSaldoActualColonesFormulario from '@/components/ConsultaSaldoActualColonesFormulario.vue'
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
