package com.emreerkahraman.enerjisaassignment.ui.newsubscription

data class NewSubscriptionViewState(
    var subscriptionType: String ="",
    var ownerType: OwnerType=OwnerType.OZEL,
    var name: String ="",
    var surname: String ="",
    var id: String ="",


)

enum class OwnerType(s: String) {
   OZEL("Özel Kişi"),TUZEL("Tüzel Kişi")
}