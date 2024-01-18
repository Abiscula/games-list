package br.com.org.gameslist.data

abstract class DAO <TModel> {

    abstract fun getList(): List<TModel>
    abstract fun add(obj: TModel)

}