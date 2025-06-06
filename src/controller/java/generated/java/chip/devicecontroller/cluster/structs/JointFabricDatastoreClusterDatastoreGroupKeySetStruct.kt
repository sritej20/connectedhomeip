/*
 *
 *    Copyright (c) 2023 Project CHIP Authors
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package chip.devicecontroller.cluster.structs

import chip.devicecontroller.cluster.*
import matter.tlv.ContextSpecificTag
import matter.tlv.Tag
import matter.tlv.TlvReader
import matter.tlv.TlvWriter

class JointFabricDatastoreClusterDatastoreGroupKeySetStruct(
  val groupKeySetID: UInt,
  val groupKeySecurityPolicy: UInt,
  val epochKey0: ByteArray?,
  val epochStartTime0: ULong?,
  val epochKey1: ByteArray?,
  val epochStartTime1: ULong?,
  val epochKey2: ByteArray?,
  val epochStartTime2: ULong?,
  val groupKeyMulticastPolicy: UInt,
) {
  override fun toString(): String = buildString {
    append("JointFabricDatastoreClusterDatastoreGroupKeySetStruct {\n")
    append("\tgroupKeySetID : $groupKeySetID\n")
    append("\tgroupKeySecurityPolicy : $groupKeySecurityPolicy\n")
    append("\tepochKey0 : $epochKey0\n")
    append("\tepochStartTime0 : $epochStartTime0\n")
    append("\tepochKey1 : $epochKey1\n")
    append("\tepochStartTime1 : $epochStartTime1\n")
    append("\tepochKey2 : $epochKey2\n")
    append("\tepochStartTime2 : $epochStartTime2\n")
    append("\tgroupKeyMulticastPolicy : $groupKeyMulticastPolicy\n")
    append("}\n")
  }

  fun toTlv(tlvTag: Tag, tlvWriter: TlvWriter) {
    tlvWriter.apply {
      startStructure(tlvTag)
      put(ContextSpecificTag(TAG_GROUP_KEY_SET_ID), groupKeySetID)
      put(ContextSpecificTag(TAG_GROUP_KEY_SECURITY_POLICY), groupKeySecurityPolicy)
      if (epochKey0 != null) {
        put(ContextSpecificTag(TAG_EPOCH_KEY0), epochKey0)
      } else {
        putNull(ContextSpecificTag(TAG_EPOCH_KEY0))
      }
      if (epochStartTime0 != null) {
        put(ContextSpecificTag(TAG_EPOCH_START_TIME0), epochStartTime0)
      } else {
        putNull(ContextSpecificTag(TAG_EPOCH_START_TIME0))
      }
      if (epochKey1 != null) {
        put(ContextSpecificTag(TAG_EPOCH_KEY1), epochKey1)
      } else {
        putNull(ContextSpecificTag(TAG_EPOCH_KEY1))
      }
      if (epochStartTime1 != null) {
        put(ContextSpecificTag(TAG_EPOCH_START_TIME1), epochStartTime1)
      } else {
        putNull(ContextSpecificTag(TAG_EPOCH_START_TIME1))
      }
      if (epochKey2 != null) {
        put(ContextSpecificTag(TAG_EPOCH_KEY2), epochKey2)
      } else {
        putNull(ContextSpecificTag(TAG_EPOCH_KEY2))
      }
      if (epochStartTime2 != null) {
        put(ContextSpecificTag(TAG_EPOCH_START_TIME2), epochStartTime2)
      } else {
        putNull(ContextSpecificTag(TAG_EPOCH_START_TIME2))
      }
      put(ContextSpecificTag(TAG_GROUP_KEY_MULTICAST_POLICY), groupKeyMulticastPolicy)
      endStructure()
    }
  }

  companion object {
    private const val TAG_GROUP_KEY_SET_ID = 0
    private const val TAG_GROUP_KEY_SECURITY_POLICY = 1
    private const val TAG_EPOCH_KEY0 = 2
    private const val TAG_EPOCH_START_TIME0 = 3
    private const val TAG_EPOCH_KEY1 = 4
    private const val TAG_EPOCH_START_TIME1 = 5
    private const val TAG_EPOCH_KEY2 = 6
    private const val TAG_EPOCH_START_TIME2 = 7
    private const val TAG_GROUP_KEY_MULTICAST_POLICY = 8

    fun fromTlv(
      tlvTag: Tag,
      tlvReader: TlvReader,
    ): JointFabricDatastoreClusterDatastoreGroupKeySetStruct {
      tlvReader.enterStructure(tlvTag)
      val groupKeySetID = tlvReader.getUInt(ContextSpecificTag(TAG_GROUP_KEY_SET_ID))
      val groupKeySecurityPolicy =
        tlvReader.getUInt(ContextSpecificTag(TAG_GROUP_KEY_SECURITY_POLICY))
      val epochKey0 =
        if (!tlvReader.isNull()) {
          tlvReader.getByteArray(ContextSpecificTag(TAG_EPOCH_KEY0))
        } else {
          tlvReader.getNull(ContextSpecificTag(TAG_EPOCH_KEY0))
          null
        }
      val epochStartTime0 =
        if (!tlvReader.isNull()) {
          tlvReader.getULong(ContextSpecificTag(TAG_EPOCH_START_TIME0))
        } else {
          tlvReader.getNull(ContextSpecificTag(TAG_EPOCH_START_TIME0))
          null
        }
      val epochKey1 =
        if (!tlvReader.isNull()) {
          tlvReader.getByteArray(ContextSpecificTag(TAG_EPOCH_KEY1))
        } else {
          tlvReader.getNull(ContextSpecificTag(TAG_EPOCH_KEY1))
          null
        }
      val epochStartTime1 =
        if (!tlvReader.isNull()) {
          tlvReader.getULong(ContextSpecificTag(TAG_EPOCH_START_TIME1))
        } else {
          tlvReader.getNull(ContextSpecificTag(TAG_EPOCH_START_TIME1))
          null
        }
      val epochKey2 =
        if (!tlvReader.isNull()) {
          tlvReader.getByteArray(ContextSpecificTag(TAG_EPOCH_KEY2))
        } else {
          tlvReader.getNull(ContextSpecificTag(TAG_EPOCH_KEY2))
          null
        }
      val epochStartTime2 =
        if (!tlvReader.isNull()) {
          tlvReader.getULong(ContextSpecificTag(TAG_EPOCH_START_TIME2))
        } else {
          tlvReader.getNull(ContextSpecificTag(TAG_EPOCH_START_TIME2))
          null
        }
      val groupKeyMulticastPolicy =
        tlvReader.getUInt(ContextSpecificTag(TAG_GROUP_KEY_MULTICAST_POLICY))

      tlvReader.exitContainer()

      return JointFabricDatastoreClusterDatastoreGroupKeySetStruct(
        groupKeySetID,
        groupKeySecurityPolicy,
        epochKey0,
        epochStartTime0,
        epochKey1,
        epochStartTime1,
        epochKey2,
        epochStartTime2,
        groupKeyMulticastPolicy,
      )
    }
  }
}
