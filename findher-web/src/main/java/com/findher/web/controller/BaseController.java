package com.findher.web.controller;


public abstract class BaseController {
//    protected final static Logger logger = LoggerFactory.getLogger();

    /**
     * 返回JSON结果
     * 
     * @param result
     * @return
     */
//    public MappingJackson2JsonView getJsonView(Result result) {
//        MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
//        jsonView.addStaticAttribute("code", result.getCode());
//        if (result.getData() != null) {
//            jsonView.addStaticAttribute("data", result.getData());
//        }
//        return jsonView;
//    }
//    
//    public MappingJackson2JsonView getSuccessJsonView(Object data) {
//        MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
//        jsonView.addStaticAttribute("code", 200);
//        jsonView.addStaticAttribute("data", data);
//        return jsonView;
//    }
//
//    protected void logStackTrace(Level level) {
//        Context ctx = Context.getContext();
//        if (ctx != null) {
//            Context.getContext().logStackTrace(level);
//        }
//    }
//
//    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//    public MappingJackson2JsonView handleMethodNotSupportedException(
//            HttpRequestMethodNotSupportedException ae) {
//        Result result = new Result();
//        result.setCode(ErrorCode.METHOD_NOT_ALLOWED.getCode());
//        return getJsonView(result);
//    }
//    
//    @ExceptionHandler(MissingServletRequestParameterException.class)
//    public MappingJackson2JsonView handleMissingParameterException(
//            MissingServletRequestParameterException ae) {
//        Result result = new Result();
//        result.setCode(ErrorCode.MISSING_PARAMETER.getCode());
//        return getJsonView(result);
//    }
//    @ExceptionHandler(CodeException.class)
//    public MappingJackson2JsonView handleCodeException(CodeException ae) {
//        Result result = new Result();
//        result.setCode(ae.getCode().getCode());
//        logger.error("handleCodeException", ae);
//        return getJsonView(result);
//    }
//    @ExceptionHandler(Exception.class)
//    public MappingJackson2JsonView handleException(Exception ae) {
//        Result result = new Result();
//        result.setCode(ErrorCode.SERVER_INTERNAL_ERROR.getCode());
//        logger.error("handleException", ae);
//        return getJsonView(result);
//    }
}
