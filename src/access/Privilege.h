/*
 *
 *    Copyright (c) 2021 Project CHIP Authors
 *    All rights reserved.
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

#pragma once

#include <cstdint>

namespace chip {
namespace Access {

// Using bitfield values so privilege set and auth mode can be stored together.
// Privilege set can have more than one value expressed (e.g. View,
// ProxyView, and Operate).
// NOTE: Every time this enum class changes, we need to update the constexpr
// "kAllPrivilegeBits" below.
enum class Privilege : uint8_t
{
    kView       = 1 << 0,
    kProxyView  = 1 << 1,
    kOperate    = 1 << 2,
    kManage     = 1 << 3,
    kAdminister = 1 << 4
};

// Constant expression that contains all the values
// defined inside the enum class "Privilege", and only those values.
constexpr uint8_t kAllPrivilegeBits =             //
    static_cast<uint8_t>(Privilege::kView) |      //
    static_cast<uint8_t>(Privilege::kProxyView) | //
    static_cast<uint8_t>(Privilege::kOperate) |   //
    static_cast<uint8_t>(Privilege::kManage) |    //
    static_cast<uint8_t>(Privilege::kAdminister);

} // namespace Access
} // namespace chip
