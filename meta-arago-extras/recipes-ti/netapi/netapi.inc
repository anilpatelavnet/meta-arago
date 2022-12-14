LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/COPYING.txt;md5=f2b4f162358b1ffaf3f2307287ca2074"

COMPATIBLE_MACHINE = "keystone"
PACKAGE_ARCH = "${MACHINE_ARCH}"

DEBIAN_NOAUTONAME_${PN} = "1"
DEBIAN_NOAUTONAME_${PN}-dev = "1"
DEBIAN_NOAUTONAME_${PN}-dbg = "1"
DEBIAN_NOAUTONAME_${PN}-staticdev = "1"

NETAPI_GIT_URI = "git://git.ti.com/git/keystone-rtos/netapi.git"
NETAPI_GIT_PROTOCOL = "https"
NETAPI_GIT_BRANCH = "master"

# Below Commit ID corresponds to "DEV.NETAPI.01.01.00.07"
NETAPI_SRCREV = "50026020384737d253668c4be80745a3653106f8"

BRANCH = "${NETAPI_GIT_BRANCH}"
SRC_URI = "${NETAPI_GIT_URI};protocol=${NETAPI_GIT_PROTOCOL};branch=${BRANCH}"
SRCREV = "${NETAPI_SRCREV}"

PV = "01.01.00.07"
INC_PR = "r0"

DEVICELIST_k2hk = "k2h k2k"
DEVICELIST_k2l  = "k2l"
DEVICELIST_k2e  = "k2e"

CHOICELIST = "yes no"

BASEDIR = "${WORKDIR}/git"
S = "${BASEDIR}/ti/runtime/netapi"
