<template>
  <aside class="menu left-panel">
    <ul class="menu-list">
      <li>
        <router-link
          to="/customer"
          v-bind:class="{
            'is-active': 'customer-dashboard' == this.$route.name,
          }"
          >Dashboard</router-link
        >
      </li>
      <li>
        <router-link
          to="/customer/profile"
          v-bind:class="{
            'is-active': 'customer-profile' == this.$route.name,
          }"
          >Profile</router-link
        >
      </li>
      <li>
        <router-link
          to="/customer/transactions"
          v-bind:class="{
            'is-active': 'customer-transactions' == this.$route.name,
          }"
          >Transactions</router-link
        >
      </li>
      <li>
        <router-link
          to="/customer/log"
          v-bind:class="{
            'is-active': 'customer-log' == this.$route.name,
          }"
          >Log</router-link
        >
      </li>
      <li>
        <router-link
          to="/customer/settings"
          v-bind:class="{
            'is-active': 'customer-settings' == this.$route.name,
          }"
          >Settings</router-link
        >
      </li>
      <li><a>Disable Account</a>
      </li>
    </ul>
  </aside>
</template>

<style>
.section-contents {
  display: inline-flex;
  padding-block-start: inherit;
}
.left-panel {
  width: fit-content;
  margin-left: 0px;
}
.section-main-contents {
  margin-left: 30px;
}
/* .style-section{
        padding: 0px;
    } */
</style>
