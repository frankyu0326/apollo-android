// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.hero_with_review

import com.apollographql.apollo.api.Mutation
import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.OperationName
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.ScalarTypeAdapters
import com.apollographql.apollo.api.ScalarTypeAdapters.Companion.DEFAULT
import com.apollographql.apollo.api.internal.InputFieldMarshaller
import com.apollographql.apollo.api.internal.QueryDocumentMinifier
import com.apollographql.apollo.api.internal.ResponseFieldMapper
import com.apollographql.apollo.api.internal.ResponseFieldMarshaller
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.SimpleOperationResponseParser
import com.apollographql.apollo.api.internal.Throws
import com.example.hero_with_review.type.Episode
import kotlin.Any
import kotlin.Array
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.collections.Map
import kotlin.jvm.Transient
import okio.BufferedSource
import okio.IOException

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter")
data class TestQuery(
  val ep: Episode
) : Mutation<TestQuery.Data, TestQuery.Data, Operation.Variables> {
  @Transient
  private val variables: Operation.Variables = object : Operation.Variables() {
    override fun valueMap(): Map<String, Any?> = mutableMapOf<String, Any?>().apply {
      this["ep"] = this@TestQuery.ep
    }

    override fun marshaller(): InputFieldMarshaller = InputFieldMarshaller.invoke { writer ->
      writer.writeString("ep", this@TestQuery.ep.rawValue)
    }
  }

  override fun operationId(): String = OPERATION_ID
  override fun queryDocument(): String = QUERY_DOCUMENT
  override fun wrapData(data: Data?): Data? = data
  override fun variables(): Operation.Variables = variables
  override fun name(): OperationName = OPERATION_NAME
  override fun responseFieldMapper(): ResponseFieldMapper<Data> = ResponseFieldMapper.invoke {
    Data(it)
  }

  @Throws(IOException::class)
  override fun parse(source: BufferedSource, scalarTypeAdapters: ScalarTypeAdapters): Response<Data>
      = SimpleOperationResponseParser.parse(source, this, scalarTypeAdapters)

  @Throws(IOException::class)
  override fun parse(source: BufferedSource): Response<Data> = parse(source, DEFAULT)

  data class CreateReview(
    val __typename: String = "Review",
    /**
     * The number of stars this review gave, 1-5
     */
    val stars: Int,
    /**
     * Comment about the movie
     */
    val commentary: String?
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@CreateReview.__typename)
      writer.writeInt(RESPONSE_FIELDS[1], this@CreateReview.stars)
      writer.writeString(RESPONSE_FIELDS[2], this@CreateReview.commentary)
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forInt("stars", "stars", null, false, null),
          ResponseField.forString("commentary", "commentary", null, true, null)
          )

      operator fun invoke(reader: ResponseReader): CreateReview = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val stars = readInt(RESPONSE_FIELDS[1])!!
        val commentary = readString(RESPONSE_FIELDS[2])
        CreateReview(
          __typename = __typename,
          stars = stars,
          commentary = commentary
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<CreateReview> = ResponseFieldMapper { invoke(it) }
    }
  }

  data class Data(
    val createReview: CreateReview?
  ) : Operation.Data {
    override fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeObject(RESPONSE_FIELDS[0], this@Data.createReview?.marshaller())
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forObject("createReview", "createReview", mapOf<String, Any>(
            "episode" to mapOf<String, Any>(
              "kind" to "Variable",
              "variableName" to "ep"),
            "review" to mapOf<String, Any>(
              "stars" to "5",
              "listOfEnums" to "[JEDI, EMPIRE, NEWHOPE]",
              "listOfStringNonOptional" to "[1, 2, 3]",
              "favoriteColor" to mapOf<String, Any>(
                "red" to "1",
                "blue" to "1.0"))), true, null)
          )

      operator fun invoke(reader: ResponseReader): Data = reader.run {
        val createReview = readObject<CreateReview>(RESPONSE_FIELDS[0]) { reader ->
          CreateReview(reader)
        }
        Data(
          createReview = createReview
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<Data> = ResponseFieldMapper { invoke(it) }
    }
  }

  companion object {
    const val OPERATION_ID: String =
        "df7f6bf82724eedee5118f165075b5de1a2b3a06d0390126bf7932dc8df3f082"

    val QUERY_DOCUMENT: String = QueryDocumentMinifier.minify(
          """
          |mutation TestQuery(${'$'}ep: Episode!) {
          |  createReview(episode: ${'$'}ep, review: {stars: 5, listOfEnums: [JEDI, EMPIRE, NEWHOPE], listOfStringNonOptional: ["1", "2", "3"], favoriteColor: {red: 1, blue: 1}}) {
          |    __typename
          |    stars
          |    commentary
          |  }
          |}
          """.trimMargin()
        )

    val OPERATION_NAME: OperationName = object : OperationName {
      override fun name(): String = "TestQuery"
    }
  }
}
