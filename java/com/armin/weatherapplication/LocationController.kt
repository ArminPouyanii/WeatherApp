package com.armin.weatherapplication

class LocationController(var model:GetLocation,var view:MainActivity) {
    fun getLocationLatitude():String{
        return model.latuide
    }
    fun getLocationLongitude():String{
        return model.longtuide
    }
    fun setLocationLat(lat:String){
        model.latuide=lat
    }
    fun setLocationLong(long:String){
        model.longtuide=long
    }

}