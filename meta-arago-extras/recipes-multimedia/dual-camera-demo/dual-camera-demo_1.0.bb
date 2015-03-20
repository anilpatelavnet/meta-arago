DESCRIPTION = "Qt Dual Camera Demo"
HOMEPAGE = "https://gitorious.org/dual-camera-demo/"
SECTION = "multimedia"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c7ca707704d3354a64feeb4f19f52eb5"

DEPENDS += "libdrm"
require recipes-core/matrix/matrix-gui-paths.inc

PR = "r8"

BRANCH = "drm"
SRCREV = "4ede12a9c6b51b7693b005b00a715056e99fa7a0"

SRC_URI = "git://gitorious.org/dual-camera-demo/dual-camera-demo.git;protocol=http;branch=${BRANCH} \
           file://desc_dual-camera.html \
           file://dual_camera_qt5.sh \
           file://dual_camera_qt4.sh \
           file://dual-camera.desktop \
"

S = "${WORKDIR}/git"

DEMO_SCRIPT = "${@base_conditional('QT_PROVIDER', 'qt5', 'dual_camera_qt5.sh', 'dual_camera_qt4.sh', d)}"

inherit qt-provider

export SDK_PATH_TARGET='${STAGING_DIR_HOST}'

# use the make targets already created in the Makefile.build files
do_install() {
    install -d ${D}/usr/bin
    install -d ${D}${MATRIX_APP_DIR}/dual-camera
    install dual_camera ${D}/usr/bin/dual_camera
    install ${WORKDIR}/${DEMO_SCRIPT} ${D}/usr/bin/dual_camera.sh
    install ${WORKDIR}/desc_dual-camera.html ${D}/${MATRIX_APP_DIR}/dual-camera
    install ${WORKDIR}/dual-camera.desktop ${D}/${MATRIX_APP_DIR}/dual-camera
}

PACKAGES += "matrix-gui-apps-dual-camera"

RDEPENDS_${PN} += "libdrm libdrm-omap"

RDEPENDS_matrix-gui-apps-dual-camera  = "matrix-gui-apps-images matrix-gui-submenus-camera ${PN}"

# Add the matrix directory to the FILES
FILES_${PN} = "/usr/bin/*"

FILES_matrix-gui-apps-dual-camera = "${MATRIX_APP_DIR}/*"
