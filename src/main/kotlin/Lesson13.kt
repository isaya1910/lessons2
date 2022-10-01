
open class Aircraft(val model: String)

class MilitaryAircraft(model: String) : Aircraft(model)

class CivilAircraft(model: String) : Aircraft(model)

/*
* class Aircraft(val model: String, val type: Int) // 0 MilitaryAircraft 1 CivilAircraft
/
