/*
  Copyright (c) 2015, 2017, Oracle and/or its affiliates. All rights reserved.

  The MySQL Connector/J is licensed under the terms of the GPLv2
  <http://www.gnu.org/licenses/old-licenses/gpl-2.0.html>, like most MySQL Connectors.
  There are special exceptions to the terms and conditions of the GPLv2 as it is applied to
  this software, see the FOSS License Exception
  <http://www.mysql.com/about/legal/licensing/foss-exception.html>.

  This program is free software; you can redistribute it and/or modify it under the terms
  of the GNU General Public License as published by the Free Software Foundation; version 2
  of the License.

  This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
  See the GNU General Public License for more details.

  You should have received a copy of the GNU General Public License along with this
  program; if not, write to the Free Software Foundation, Inc., 51 Franklin St, Fifth
  Floor, Boston, MA 02110-1301  USA

 */

package com.mysql.cj.core.exceptions;

import com.mysql.cj.api.conf.PropertySet;
import com.mysql.cj.api.io.ServerSession;

public class CJCommunicationsException extends CJException {

    private static final long serialVersionUID = 344035358493554245L;

    public CJCommunicationsException() {
        super();
    }

    public CJCommunicationsException(String message) {
        super(message);
    }

    public CJCommunicationsException(String message, Throwable cause) {
        super(message, cause);
    }

    public CJCommunicationsException(Throwable cause) {
        super(cause);
    }

    protected CJCommunicationsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public void init(PropertySet propertySet, ServerSession serverSession, long lastPacketSentTimeMs, long lastPacketReceivedTimeMs) {
        this.exceptionMessage = ExceptionFactory.createLinkFailureMessageBasedOnHeuristics(propertySet, serverSession, lastPacketSentTimeMs,
                lastPacketReceivedTimeMs, getCause());
    }

}
